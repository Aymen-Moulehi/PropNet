package tn.esprit.propnetapp.locality;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/locality")
public class LocalityRestController {
    ILocalityService localityService;

    @PostMapping("/add-locality")
    public Locality addLocality(@RequestBody Locality locality) {
        return localityService.addLocality(locality);
    }
    @GetMapping("/retrieve-all-localities")
    public List<Locality> getAllLocalities() {
        return localityService.retrieveAllLocalities();
    }
    @GetMapping("/retrieve-locality/{locality-id}")
    public Locality retrieveLocality(@PathVariable("locality-id") Long localityId) {
        return localityService.retrieveLocality(localityId);
    }
    @DeleteMapping("/remove-locality/{locality-id}")
    public void removeLocality(@PathVariable("locality-id") Long localityId) {
        localityService.deleteLocality(localityId);
    }
    @PutMapping("/update-locality")
    public Locality updateLocality(@RequestBody Locality locality) {
        return localityService.updateLocality(locality);
    }
}
