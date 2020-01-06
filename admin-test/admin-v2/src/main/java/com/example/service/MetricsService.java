package com.example.service;

import com.example.config.LocalCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class MetricsService implements SchedulingConfigurer {


    @Scheduled(fixedDelay = 30 * 1000)
    public void fetchMetricsValue() {

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                System.out.println(new Date());
                System.out.println(111111);
            }
        }, triggerContext -> {
            // 任务触发，可修改任务的执行周期
            PeriodicTrigger trigger = new PeriodicTrigger(LocalCache.settingCache.get("periodic"), TimeUnit.SECONDS);
            Date nextExec = trigger.nextExecutionTime(triggerContext);
            return nextExec;
        });
    }
}
