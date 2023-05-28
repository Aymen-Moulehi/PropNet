package tn.esprit.propnetapp.realestatellisting;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/realEstateListing")
public class RealEstateListingRestController {
    IRealEstateListingService realEstateListingService;

    @PostMapping("/add-realEstateListing")
    public RealEstateListing addRealEstateListingS(@RequestBody RealEstateListing realEstateListing) {
        return realEstateListingService.addRealEstateListing(realEstateListing);
    }
}
