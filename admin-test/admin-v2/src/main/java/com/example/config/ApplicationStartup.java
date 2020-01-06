package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 应用启动时从eureka获取服务实例
 */
@Component
public class ApplicationStartup implements CommandLineRunner {

    private final DiscoveryClient discoveryClient;

    public ApplicationStartup(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstances) {
                LocalCache.put(serviceName, serviceInstance.getUri().toString());
            }
        }
    }
}
