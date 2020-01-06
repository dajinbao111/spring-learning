package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {



    @Scheduled(fixedDelay = 30 * 1000)
    public void fetchMetricsValue() {

    }
}
