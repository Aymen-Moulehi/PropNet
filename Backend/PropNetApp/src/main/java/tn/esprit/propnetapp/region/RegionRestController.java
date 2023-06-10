package tn.esprit.propnetapp.region;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class RegionRestController {
    IRegionService regionService;

    @PostMapping("/add-region")
    public Region addRegion(@RequestBody Region region) {
        return regionService.addRegion(region);
    }
    @GetMapping("/retrieve-all-regions")
    public List<Region> getAllRegions() {
        return regionService.retrieveAllRegions();
    }
    @GetMapping("/retrieve-region/{region-id}")
    public Region retrieveRegion(@PathVariable("region-id") Long regionId) {
        return regionService.retrieveRegion(regionId);
    }
    @DeleteMapping("/remove-region/{region-id}")
    public void removeRegion(@PathVariable("region-id") Long regionId) {
        regionService.deleteRegion(regionId);
    }
    @PutMapping("/update-region")
    public Region updateRegion(@RequestBody Region region) {
        return regionService.updateRegion(region);
    }
}
