package tn.esprit.propnetapp.locality;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/locality")
public class LocalityRestController {
    ILocalityService localityService;

    @PostMapping("/add-locality")
    public Locality addLocalityS(@RequestBody Locality locality) {
        return localityService.addLocality(locality);
    }
}
