package com.example.config;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;

public class LocalCache {

    /**
     * 内存方式存储服务名称和服务实例
     * key:serviceName, value:serviceInstance.uri
     */
    private Multimap<String, String> appCache = ArrayListMultimap.create();

    /**
     * 指标开关
     */
    private Table<String, String, Boolean> metricsCache = HashBasedTable.create();

    /**
     * 设置收集周期
     */
    private long period = 30L;
    /**
     * 收集一次耗时
     */
    private long timeSpent = 0L;

    private LocalCache() {
        for (Metrics metrics : Metrics.values()) {
            metricsCache.put(metrics.getTag(), metrics.getDescription(), metrics.isOpen());
        }
    }

    public void setAppCache(Multimap<String, String> multimap) {
        synchronized (appCache) {
            this.appCache = multimap;
        }
    }

    public Multimap<String, String> getAppCache() {
        return appCache;
    }

    public Table<String, String, Boolean> getMetricsCache() {
        return metricsCache;
    }

    private static class LocalCacheHolder {
        private static LocalCache instance = new LocalCache();
    }

    public static LocalCache getInstance() {
        return LocalCacheHolder.instance;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(long timeSpent) {
        this.timeSpent = timeSpent;
    }
}
