package com.example.web;

import com.example.config.LocalCache;
import com.google.common.collect.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MetricsController {

    @GetMapping("/metrics")
    public Set<Table.Cell<String, String, Integer>> metrics() {
        return LocalCache.metricsCache.cellSet();
    }


}
