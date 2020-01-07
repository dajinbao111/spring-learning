package com.example.service;

import com.example.config.LocalCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class MetricsService implements SchedulingConfigurer {

    private final RestTemplate restTemplate;

    public MetricsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Multimap<String, String> apps = ArrayListMultimap.create();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            // 任务逻辑
            long timeStart = System.currentTimeMillis();
            apps.clear();
            apps.putAll(LocalCache.getInstance().getAppCache());
            List<String> tags = findMetricsOpened();
            if (!apps.isEmpty() && !tags.isEmpty()) {
                Set<String> keySet = apps.keySet();
                for (String key : keySet) {
                    Collection<String> coll = apps.get(key);
                    Iterator<String> it = coll.iterator();
                    while (it.hasNext()) {
                        String baseUri = it.next();
                        for (String tag : tags) {
                            String url = String.format("%s/actuator/metrics/%s", baseUri, tag);
                            String body = restTemplate.getForObject(url, String.class);
                            System.out.println(body);
                        }
                    }
                }
            }
            // 记录一下收集一次耗时
            LocalCache.getInstance().setTimeSpent((System.currentTimeMillis() - timeStart) / 1000);
        }, triggerContext -> {
            // 任务触发，可修改任务的执行周期
            Long period = LocalCache.getInstance().getPeriod();
            PeriodicTrigger trigger = new PeriodicTrigger(period, TimeUnit.SECONDS);
            Date nextExec = trigger.nextExecutionTime(triggerContext);
            return nextExec;
        });
    }

    /**
     * 找出状态是open的指标
     *
     * @return
     */
    private List<String> findMetricsOpened() {
        List<String> tags = new ArrayList<>();
        Set<Table.Cell<String, String, Boolean>> set = LocalCache.getInstance().getMetricsCache().cellSet();
        for (Table.Cell<String, String, Boolean> cell : set) {
            if (cell.getValue()) {
                tags.add(cell.getRowKey());
            }
        }
        return tags;
    }
}
