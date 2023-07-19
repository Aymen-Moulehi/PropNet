package tn.esprit.propnetapp.realestatellisting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.post.Post;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface RealEstateListingRepository extends JpaRepository<RealEstateListing, Integer> {
    List<RealEstateListing> findByRealEstateStatus(RealEstateStatus status);
    RealEstateListing findRealEstateListingByIdRealEstateListing(Integer idRealEstateListing);
    @Query("SELECT u FROM RealEstateListing u WHERE FUNCTION('MONTH', u.creationDate) = FUNCTION('MONTH', CURRENT_DATE()) " +
            "AND FUNCTION('YEAR', u.creationDate) = FUNCTION('YEAR', CURRENT_DATE())")
    List<RealEstateListing> getRealEstateCreatedThisMonth();
}
