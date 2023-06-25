package tn.esprit.propnetapp.realestatellisting;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.post.Post;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/realEstateListing")
public class RealEstateListingRestController {
    IRealEstateListingService realEstateListingService;

    @PostMapping("/add-realEstateListing")
    public RealEstateListing addRealEstateListing(@RequestBody RealEstateListing realEstateListing) {
        return realEstateListingService.addRealEstateListing(realEstateListing);
    }
    @GetMapping("/pending")
    @CrossOrigin
    public List<RealEstateListing> getRealEstateListingPENDING() {
        return realEstateListingService.getRealEstateListingPendding();
    }
    @GetMapping("/accepted")
    @CrossOrigin
    public List<RealEstateListing> getRealEstateListingACCEPTED() {
        return realEstateListingService.getRealEstateListingAccepted();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public RealEstateListing addPostS(@PathVariable("id") Integer id) {
        return realEstateListingService.getRealEstateListingById(id);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public void deleteRealEstateListing(@PathVariable("id") Integer id) {
        realEstateListingService.deleteRealEstateListing(id);
    }


    @PutMapping("/accepted/{id}")
    @CrossOrigin
    public RealEstateListing accepteRealEstateListing(@PathVariable("id") Integer id) {
        return realEstateListingService.accepteRealEstateListing(id);
    }
}
