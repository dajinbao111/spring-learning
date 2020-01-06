package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationsController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/applications")
    public List applications() {
        List<String> services = new ArrayList<>();
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstances) {
                services.add(String.format("%s:%s", serviceName, serviceInstance.getUri()));
            }
        }
        return services;
    }
}
