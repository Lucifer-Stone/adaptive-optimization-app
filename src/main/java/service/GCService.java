package service;

import org.springframework.stereotype.Service;

import javax.management.MBeanServer;
import java.lang.management.*;
import java.util.*;

@Service
public class GarbageCollectionService {

    public Map<String, Object> getGarbageCollectionMetrics() {
        Map<String, Object> gcMetrics = new HashMap<>();

        // Fetch GC beans
        List<Map<String, Object>> gcDetails = new ArrayList<>();
        for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            Map<String, Object> info = new HashMap<>();
            info.put("name", gcBean.getName());
            info.put("collectionCount", gcBean.getCollectionCount());
            info.put("collectionTimeMs", gcBean.getCollectionTime());
            gcDetails.add(info);
        }

        // Memory usage
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapUsage = memoryBean.getNonHeapMemoryUsage();

        Map<String, Object> heap = new HashMap<>();
        heap.put("init", heapUsage.getInit());
        heap.put("used", heapUsage.getUsed());
        heap.put("committed", heapUsage.getCommitted());
        heap.put("max", heapUsage.getMax());

        Map<String, Object> nonHeap = new HashMap<>();
        nonHeap.put("init", nonHeapUsage.getInit());
        nonHeap.put("used", nonHeapUsage.getUsed());
        nonHeap.put("committed", nonHeapUsage.getCommitted());
        nonHeap.put("max", nonHeapUsage.getMax());

        // Finalization queue
        gcMetrics.put("pendingFinalizationCount", memoryBean.getObjectPendingFinalizationCount());
        gcMetrics.put("heapMemory", heap);
        gcMetrics.put("nonHeapMemory", nonHeap);
        gcMetrics.put("gcCollectors", gcDetails);
        gcMetrics.put("timestamp", new Date().toString());

        return gcMetrics;
    }
}
