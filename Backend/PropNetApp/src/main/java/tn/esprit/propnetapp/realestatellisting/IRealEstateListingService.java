package tn.esprit.propnetapp.realestatellisting;

import tn.esprit.propnetapp.post.Post;

import java.util.List;

import java.util.List;

public interface IRealEstateListingService {
    RealEstateListing addRealEstateListing(RealEstateListing realEstateListing);

    List<RealEstateListing> getRealEstateListingPendding();

    List<RealEstateListing> getRealEstateListingAccepted();

    RealEstateListing getRealEstateListingById(Integer idRealEstateListing);
    void deleteRealEstateListing(Integer id);
    RealEstateListing accepteRealEstateListing(Integer id);

    List<RealEstateListing> retrieveAllRealEstateListings();
}