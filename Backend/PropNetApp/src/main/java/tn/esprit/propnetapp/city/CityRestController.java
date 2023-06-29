package tn.esprit.propnetapp.city;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class CityRestController {
    ICityService regionService;

    @PostMapping("/add-region")
    public City addRegion(@RequestBody City city) {
        return regionService.addRegion(city);
    }
    @GetMapping("/retrieve-all-regions")
    public List<City> getAllRegions() {
        return regionService.retrieveAllRegions();
    }
    @GetMapping("/retrieve-region/{region-id}")
    public City retrieveRegion(@PathVariable("region-id") Integer regionId) {
        return regionService.retrieveRegion(regionId);
    }
    @DeleteMapping("/remove-region/{region-id}")
    public void removeRegion(@PathVariable("region-id") Integer regionId) {
        regionService.deleteRegion(regionId);
    }
    @PutMapping("/update-region")
    public City updateRegion(@RequestBody City city) {
        return regionService.updateRegion(city);
    }
}
