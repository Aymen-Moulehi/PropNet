package tn.esprit.propnetapp.realestatellisting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RealEstateListingRepository extends JpaRepository<RealEstateListing, Integer> {

}
