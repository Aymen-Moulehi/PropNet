package tn.esprit.propnetapp.realestatellisting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateListingRepository extends JpaRepository<RealEstateListing, Integer> {
    RealEstateListing findRealEstateListingsByIdRealEstateListing(Integer idRealEstateListing);

    void deleteByidRealEstateListing(Integer idRealEstateListing);



}
