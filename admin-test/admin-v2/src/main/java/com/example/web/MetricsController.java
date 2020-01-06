package com.example.web;

import com.example.config.LocalCache;
import com.example.config.Metrics;
import com.google.common.collect.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MetricsController {

    @GetMapping("/metrics")
    public Set<Table.Cell<String, String, Boolean>> metrics() {
        return LocalCache.metricsCache.cellSet();
    }

    @PutMapping("/metrics/${tag}")
    public void modify(@PathVariable("tag") String tag) {
        Metrics metrics = Metrics.getMetrics(tag);
        if (metrics != null) {
            LocalCache.metricsCache.put(metrics.getTag(), metrics.getDescription(), !metrics.isOpen());
        }
    }
}
