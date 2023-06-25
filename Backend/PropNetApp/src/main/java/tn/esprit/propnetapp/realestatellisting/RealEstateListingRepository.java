package tn.esprit.propnetapp.realestatellisting;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.propnetapp.post.Post;

import java.util.List;

public interface RealEstateListingRepository extends JpaRepository<RealEstateListing, Integer> {
    List<RealEstateListing> findByRealEstateStatus(RealEstateStatus status);
    RealEstateListing findRealEstateListingByIdRealEstateListing(Integer idRealEstateListing);

}
