package com.example.config;

/**
 * @author zhangxu
 */

public enum Metrics {

    SYSTEM_CPU_COUNT("system.cpu.count", "CPU数量"),
    SYSTEM_CPU_USAGE("system.cpu.usage", "系统CPU使用率");

    /**
     * 指标键
     */
    private String tag;
    /**
     * 指标说明
     */
    private String desc;

    Metrics(String tag, String desc) {
        this.tag = tag;
        this.desc = desc;
    }

    public static String getDesc(String tag) {
        for (Metrics metrics : Metrics.values()) {
            if (metrics.getTag().equals(tag)) {
                return metrics.getDesc();
            }
        }
        return null;
    }

    public String getTag() {
        return tag;
    }

    public String getDesc() {
        return desc;
    }
}
