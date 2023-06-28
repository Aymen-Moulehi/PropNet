package tn.esprit.propnetapp.realestatellisting;

import java.util.List;

public interface IRealEstateListingService {
    RealEstateListing addRealEstateListing(RealEstateListing realEstateListing);
    List<RealEstateListing> retrieveAllRealEstateListings();
}