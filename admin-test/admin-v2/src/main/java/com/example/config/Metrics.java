package com.example.config;

/**
 * @author zhangxu
 */

public enum Metrics {

    JVM_MEMORY_MAX("jvm.memory.max", "The maximum amount of memory in bytes that can be used for memory management", false),
    JVM_MEMORY_USED("jvm.memory.used", "The amount of used memory", false),
    JVM_MEMORY_COMMITTED("jvm.memory.committed", "The amount of memory in bytes that is committed for the Java virtual machine to use", false),
    JVM_BUFFER_MEMORY_USED("jvm.buffer.memory.used", "An estimate of the memory that the Java virtual machine is using for this buffer pool", false),
    JVM_THREADS_DAEMON("jvm.threads.daemon", "The current number of live daemon threads", false),
    JVM_THREADS_LIVE("jvm.threads.live", "The current number of live threads including both daemon and non-daemon threads", false),
    JVM_THREADS_PEAK("jvm.threads.peak", "The peak live thread count since the Java virtual machine started or peak was reset", false),
    JVM_GC_MEMORY_PROMOTED("jvm.gc.memory.promoted", "Count of positive increases in the size of the old generation memory pool before GC to after GC", false),
    JVM_GC_MAX_DATA_SIZE("jvm.gc.max.data.size", "Max size of old generation memory pool", false),
    JVM_GC_PAUSE("jvm.gc.pause", "Time spent in GC pause", false),
    JVM_GC_MEMORY_ALLOCATED("jvm.gc.memory.allocated", "Incremented for an increase in the size of the young generation memory pool after one GC to before the next", false),
    JVM_CLASSES_LOADED("jvm.classes.loaded", "The number of classes that are currently loaded in the Java virtual machine", false),
    JVM_CLASSES_UNLOADED("jvm.classes.unloaded", "The total number of classes unloaded since the Java virtual machine has started execution", false),
    JVM_GC_LIVE_DATA_SIZE("jvm.gc.live.data.size", "Size of old generation memory pool after a full GC", false),
    JVM_BUFFER_COUNT("jvm.buffer.count", "An estimate of the number of buffers in the pool", false),
    JVM_THREADS_STATES("jvm.threads.states", "The current number of threads having ${state} state", false),
    JVM_BUFFER_TOTAL_CAPACITY("jvm.buffer.total.capacity", "An estimate of the total capacity of the buffers in this pool", false),
    SYSTEM_CPU_COUNT("system.cpu.count", "The number of processors available to the Java virtual machine", false),
    SYSTEM_CPU_USAGE("system.cpu.usage", "The recent cpu usage for the whole system", false),
    PROCESS_CPU_USAGE("process.cpu.usage", "The recent cpu usage for the Java Virtual Machine process", false),
    PROCESS_START_TIME("process.start.time", "Start time of the process since unix epoch", false),
    PROCESS_UPTIME("process.uptime", "The uptime of the Java virtual machine", false);

    /**
     * 指标键
     */
    private String tag;
    /**
     * 指标说明
     */
    private String description;
    /**
     * 是否开启
     */
    private boolean open;

    Metrics(String tag, String description, boolean open) {
        this.tag = tag;
        this.description = description;
        this.open = open;
    }

    public static Metrics getMetrics(String tag) {
        for (Metrics metrics : Metrics.values()) {
            if (metrics.getTag().equals(tag)) {
                return metrics;
            }
        }
        return null;
    }

    public static String getDescription(String tag) {
        for (Metrics metrics : Metrics.values()) {
            if (metrics.getTag().equals(tag)) {
                return metrics.getDescription();
            }
        }
        return null;
    }

    public static boolean isOpen(String tag) {
        for (Metrics metrics : Metrics.values()) {
            if (metrics.getTag().equals(tag)) {
                return metrics.isOpen();
            }
        }
        return false;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOpen() {
        return open;
    }
}
