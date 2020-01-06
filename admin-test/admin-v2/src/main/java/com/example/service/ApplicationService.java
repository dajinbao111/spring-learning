package com.example.service;

import com.example.config.LocalCache;
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

    /**
     * 每30s从eureka同步application信息
     * fixedRate 上一次开始执行时间点之后n秒再执行
     * fixedDelay 上一次执行完毕时间点之后n秒再执行
     */
    @Scheduled(fixedDelay = 30 * 1000)
    public void syncApplications() {
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstances) {
                if (!LocalCache.appCache.containsKey(serviceName)) {
                    // 整个服务不存在
                    LocalCache.appCache.removeAll(serviceName);
                } else if (!LocalCache.appCache.containsEntry(serviceName, serviceInstance)) {
                    // 服务中的某个实例不存在
                    LocalCache.appCache.remove(serviceName, serviceInstance);
                } else {
                    // 新的服务实例
                    LocalCache.appCache.put(serviceName, serviceInstance.getUri().toString());
                }
            }
        }
    }
}
