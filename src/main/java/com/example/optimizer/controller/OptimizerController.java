@RestController
@RequestMapping("/optimize")
public class OptimizationController {

    private final OptimizationService service;

    public OptimizationController(OptimizationService service) {
        this.service = service;
    }

    @GetMapping("/pool")
    public String adjustPool(@RequestParam(defaultValue = "50") int size) {
        return service.adjustConnectionPool(size);
    }

    @GetMapping("/cache")
    public String adjustCache(@RequestParam(defaultValue = "60") int ttlSeconds) {
        return service.adjustCacheTTL(ttlSeconds);
    }

    @GetMapping("/gc")
    public String tuneGC() {
        return service.tuneGC();
    }

    @GetMapping("/cdn")
    public String optimizeCDN(@RequestParam(defaultValue = "us-east") String region) {
        return service.optimizeCDN(region);
    }
}
