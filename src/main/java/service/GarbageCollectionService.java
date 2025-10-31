package service;

import org.springframework.stereotype.Service;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GarbageCollectionService {

    public Map<String, Object> getGarbageCollectionMetrics() {
        Map<String, Object> metrics = new HashMap<>();

        // Collect GC stats
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            metrics.put(gcBean.getName() + "_collectionCount", gcBean.getCollectionCount());
            metrics.put(gcBean.getName() + "_collectionTime(ms)", gcBean.getCollectionTime());
        }

        // Collect memory usage
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryMXBean.getNonHeapMemoryUsage();

        metrics.put("heap_used(MB)", heap.getUsed() / (1024 * 1024));
        metrics.put("heap_committed(MB)", heap.getCommitted() / (1024 * 1024));
        metrics.put("heap_max(MB)", heap.getMax() / (1024 * 1024));
        metrics.put("nonheap_used(MB)", nonHeap.getUsed() / (1024 * 1024));

        return metrics;
    }
}
