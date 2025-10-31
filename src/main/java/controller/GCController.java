package controller;

import org.springframework.web.bind.annotation.*;
import service.GarbageCollectionService;
import java.util.Map;

@RestController
@RequestMapping("/api/metrics/gc")
public class GCController {

    private final GarbageCollectionService gcService;

    public GCController(GarbageCollectionService gcService) {
        this.gcService = gcService;
    }

    @GetMapping
    public Map<String, Object> getCurrentGCMetrics() {
        return gcService.getGarbageCollectionMetrics();
    }
}
