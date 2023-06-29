package tn.esprit.propnetapp.realestatellisting;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.post.Post;

import java.util.List;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/realEstateListing")
@Slf4j
public class RealEstateListingRestController {
    IRealEstateListingService realEstateListingService;
    FilterRealEstateListing filterRealEstateListing;

    @PostMapping("/add-realEstateListing")
    @CrossOrigin
    public RealEstateListing addRealEstateListingS(@RequestBody RealEstateListing realEstateListing) {
        return realEstateListingService.addRealEstateListing(realEstateListing);
    }
    @GetMapping("retrieve-all-RealEstateListings")
    @CrossOrigin
    public List<RealEstateListing> retrieveAllRealEstateListings(){
        return realEstateListingService.retrieveAllRealEstateListings();
    }

    /*    @PostMapping("/filter")
        @CrossOrigin
        public List<RealEstateListing> filterAnnouncements(@RequestBody AllocationFilter filterDTO) {
            // Convert AllocationFilterDTO to individual filter parameters
            String government = filterDTO.getgovernorate();
            String region = filterDTO.getCity();
            Float maxPrice = filterDTO.getMaxPrice();
            PropertyType propertyType = filterDTO.getPropertyType();
            Operation operation = filterDTO.getOperation();
            Boolean realEstateIsSold = filterDTO.getRealEstateIsSold();
            RealEstateStatus realEstateStatus = filterDTO.getRealEstateStatus();
            Integer numberOfBedrooms = filterDTO.getNumberOfBedrooms();
            log.info(filterDTO.getgovernorate());
            log.info(filterDTO.getMaxPrice().toString());
            log.info(filterDTO.getOperation().toString());
            log.info(filterDTO.getPropertyType().toString());
            log.info(filterDTO.getCity());
            // Use the filter parameters to query the repository
            return filterRealEstateListing.filterRealEstateListings(government, region, maxPrice, propertyType, operation,numberOfBedrooms);
        }*/
    @PostMapping("/advanced-filter")
    @CrossOrigin
    public List<RealEstateListing> advancedFilterAnnouncements(@RequestBody AllocationFilter filterDTO) {
        // Convert AllocationFilterDTO to individual filter parameters
        String governorate = filterDTO.getGovernorate().getName();
        String city = filterDTO.getCity().getName();
        Float maxPrice = filterDTO.getMaxPrice();
        Float minArea = filterDTO.getMinArea();
        Operation operation = filterDTO.getOperation();
        Boolean realEstateIsSold = filterDTO.getRealEstateIsSold();
        RealEstateStatus realEstateStatus = filterDTO.getRealEstateStatus();
        Integer numberOfBedrooms = filterDTO.getNumberOfBedrooms();
        Integer numberOfBathrooms = filterDTO.getNumberOfBathrooms();
        PropertyType propertyType = filterDTO.getPropertyType();
        Boolean hasParking = filterDTO.getHasParking();
        Boolean hasGarden = filterDTO.getHasGarden();
        Boolean hasBalcony = filterDTO.getHasBalcony();
        Boolean hasPool = filterDTO.getHasPool();
        Boolean isFurnished = filterDTO.getFurnished();
        Boolean hasSecurity = filterDTO.getHasSecurity();
        Integer builtYear = filterDTO.getBuiltYear();
        Integer floorNumber = filterDTO.getFloorNumber();
        String orderBy = filterDTO.getOrderBy();

        log.info(filterDTO.getCity().getName());
        log.info(filterDTO.getGovernorate().getName());
        System.out.println(filterDTO.getMaxPrice());
        log.info(filterDTO.getOrderBy());
        log.info(filterRealEstateListing.advancedFilterAnnouncements(governorate, city, maxPrice, minArea, operation, numberOfBedrooms, numberOfBathrooms, propertyType, hasBalcony, hasGarden, hasParking, hasPool, hasSecurity, isFurnished, builtYear, floorNumber, orderBy).toString());

        // Use the filter parameters to query the repository
        return filterRealEstateListing.advancedFilterAnnouncements(governorate, city, maxPrice, minArea, operation, numberOfBedrooms, numberOfBathrooms, propertyType, hasBalcony, hasGarden, hasParking, hasPool, hasSecurity, isFurnished, builtYear, floorNumber, orderBy);
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
