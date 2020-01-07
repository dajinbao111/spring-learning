package com.example.service;

import com.example.config.LocalCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final DiscoveryClient discoveryClient;

    public ApplicationService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    private Multimap<String, String> apps = ArrayListMultimap.create();

    /**
     * 每30s从eureka同步application信息
     * fixedRate 上一次开始执行时间点之后n秒再执行
     * fixedDelay 上一次执行完毕时间点之后n秒再执行
     */
    @Scheduled(fixedDelay = 60 * 1000)
    public void syncApplications() {
        apps.clear();
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstances) {
                apps.put(serviceName, serviceInstance.getUri().toString());
            }
        }
        LocalCache.getInstance().setAppCache(apps);
    }
}
