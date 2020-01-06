package com.example.config;

import com.google.common.collect.*;

import java.util.Map;

public class LocalCache {

    /**
     * 内存方式存储服务名称和服务实例
     * key:serviceName, value:serviceInstance
     */
    public static Multimap<String, String> appCache = ArrayListMultimap.create();

    /**
     * 指标开关
     */
    public static Table<String, String, Boolean> metricsCache = HashBasedTable.create();

    static {
        for (Metrics metrics : Metrics.values()) {
            metricsCache.put(metrics.getTag(), metrics.getDescription(), metrics.isOpen());
        }
    }

    /**
     * 设置
     */
    public static Map<String, String> settingCache = Maps.newHashMap();
}
