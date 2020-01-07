package com.example;

import com.example.config.LocalCache;
import com.example.config.Metrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@RestController
public class AdminV2Application {

    public static void main(String[] args) {
        SpringApplication.run(AdminV2Application.class, args);
    }

    @PutMapping("/period/{value}")
    public ResponseEntity<Void> period(@PathVariable("value") String value) {
        LocalCache.getInstance().setPeriod(Long.valueOf(value));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/apps")
    public Object apps() {
        return LocalCache.getInstance().getAppCache().entries();
    }

    @GetMapping("/metrics")
    public Object metrics() {
        return LocalCache.getInstance().getMetricsCache().cellSet();
    }

    @PutMapping("/metrics/{tag}")
    public ResponseEntity<Void> metrics(@PathVariable("tag") String tag) {
        Metrics metrics = Metrics.getMetrics(tag);
        if (metrics != null) {
            LocalCache.getInstance().getMetricsCache().put(metrics.getTag(), metrics.getDescription(), !metrics.isOpen());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
