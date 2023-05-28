package tn.esprit.propnetapp.region;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class RegionRestController {
    IRegionService regionService;

    @PostMapping("/add-region")
    public Region addRegionS(@RequestBody Region region) {
        return regionService.addRegion(region);
    }
}
