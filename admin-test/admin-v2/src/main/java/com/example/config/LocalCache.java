package com.example.config;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;

public class LocalCache {

    /**
     * 内存方式存储服务名称和服务实例
     * key:serviceName, value:serviceInstance
     *
     */
    public static Multimap<String, String> appCache = ArrayListMultimap.create();

    /**
     * 指标开关,0:Off 1:On
     */
    public static Table<String, String, Integer> metricsCache = HashBasedTable.create();

    static {
        metricsCache.put(MetricsTags.SYSTEM_CPU_COUNT, Metrics.getDesc(MetricsTags.SYSTEM_CPU_COUNT), 0);
        metricsCache.put(MetricsTags.SYSTEM_CPU_USAGE, Metrics.getDesc(MetricsTags.SYSTEM_CPU_USAGE), 0);
    }
}
