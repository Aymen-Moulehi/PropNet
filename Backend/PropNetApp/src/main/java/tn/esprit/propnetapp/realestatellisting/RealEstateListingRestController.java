package tn.esprit.propnetapp.realestatellisting;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/realEstateListing")
public class RealEstateListingRestController {
    IRealEstateListingService realEstateListingService;

    @PostMapping("/add-realEstateListing")
    public RealEstateListing addRealEstateListingS(@RequestBody RealEstateListing realEstateListing) {
        return realEstateListingService.addRealEstateListing(realEstateListing);
    }


    @GetMapping("/get-realEstateListing/{id}")
    public RealEstateListing getRealEstateListing(@PathVariable("id") Integer idRealEstateListing) {
        return realEstateListingService.getRealEstateListingbyId(idRealEstateListing);
    }

    @GetMapping("/getAll-realEstateListing")
    public List<RealEstateListing> getRealEstateListing() {
        return realEstateListingService.getAllRealEstateListing();
    }



}
