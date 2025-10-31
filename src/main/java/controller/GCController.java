package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.GarbageCollectionService;
import java.util.Map;

@RestController
@RequestMapping("/api/metrics")
public class GCController {

    @Autowired
    private GarbageCollectionService garbageCollectionService;

    @GetMapping("/gc")
    public Map<String, Object> getGarbageCollectionMetrics() {
        return garbageCollectionService.getGarbageCollectionMetrics();
    }
}
