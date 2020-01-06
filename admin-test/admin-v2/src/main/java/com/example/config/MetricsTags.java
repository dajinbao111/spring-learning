package com.example.config;

public interface MetricsTags {

    /**
     * JVM最大内存
     */
    String JVM_MEMORY_MAX = "jvm.memory.max";
    /**
     * GC时，老年代分配的内存空间
     */
    String JVM_GC_MEMORY_PROMOTED = "jvm.gc.memory.promoted";
    /**
     * 	JVM已用内存
     */
    String JVM_MEMORY_USED = "jvm.memory.used";
    /**
     * GC时，老年代的最大内存空间
     */
    String JVM_GC_MAX_DATA_SIZE = "jvm.gc.max.data.size";
    /**
     * GC耗时
     */
    String JVM_GC_PAUSE = "jvm.gc.pause";
    /**
     * JVM可用内存
     */
    String JVM_MEMORY_COMMITTED = "jvm.memory.committed";
    /**
     * JVM缓冲区已用内存
     */
    String JVM_BUFFER_MEMORY_USED = "jvm.buffer.memory.used";
    /**
     * JVM守护线程数
     */
    String JVM_THREADS_DAEMON = "jvm.threads.daemon";
    /**
     * GC时，年轻代分配的内存空间
     */
    String JVM_GC_MEMORY_ALLOCATED = "jvm.gc.memory.allocated";
    /**
     * JVM当前活跃线程数
     */
    String JVM_THREADS_LIVE = "jvm.threads.live";
    /**
     * 	JVM峰值线程数
     */
    String JVM_THREADS_PEAK = "jvm.threads.peak";
    /**
     * 	加载classes数
     */
    String JVM_CLASSES_LOADED = "jvm.classes.loaded";
    /**
     * 未加载的classes数
     */
    String JVM_CLASSES_UNLOADED = "jvm.classes.unloaded";
    /**
     * 	FullGC时，老年代的内存空间
     */
    String JVM_GC_LIVE_DATA_SIZE = "jvm.gc.live.data.size";
    /**
     * 当前缓冲区数
     */
    String JVM_BUFFER_COUNT = "jvm.buffer.count";

    String JVM_THREADS_STATES = "jvm.threads.states";

    String JVM_BUFFER_TOTAL_CAPACITY = "jvm.buffer.total.capacity";

    /**
     * CPU数量
     */
    String SYSTEM_CPU_COUNT = "system.cpu.count";
    /**
     * 系统CPU使用率
     */
    String SYSTEM_CPU_USAGE = "system.cpu.usage";
    /**
     * 当前进程CPU使用率
     */
    String PROCESS_CPU_USAGE = "process.cpu.usage";
    /**
     * 应用启动时间点
     */
    String PROCESS_START_TIME = "process.start.time";
    /**
     * 应用已运行时间
     */
    String PROCESS_UPTIME = "process.uptime";
    /**
     * http请求调用情况
     */
    String HTTP_SERVER_REQUESTS = "http.server.requests";
}
