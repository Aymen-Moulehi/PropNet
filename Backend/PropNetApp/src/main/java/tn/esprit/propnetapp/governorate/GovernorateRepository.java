package tn.esprit.propnetapp.governorate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface GovernorateRepository extends JpaRepository<Governorate, Integer> {

    @Query("SELECT g.name AS GovernorateName, " +
            "(SELECT r.Title FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MIN(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MinPriceTitle, " +
            "(SELECT r.Longitude FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MIN(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MinPriceLongitude, " +
            "(SELECT r.Latitude FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MIN(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MinPriceLatitude, " +
            "(SELECT r.Title FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MAX(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MaxPriceTitle, " +
            "(SELECT r.Longitude FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MAX(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MaxPriceLongitude, " +
            "(SELECT r.Latitude FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MAX(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MaxPriceLatitude, " +
            "(SELECT r.price FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MIN(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MinPrice, " +
            "(SELECT r.price FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MAX(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS MaxPrice, " +
            "(SELECT r.idRealEstateListing FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MIN(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS idRealEstateMinPrice, " +
            "(SELECT r.idRealEstateListing FROM RealEstateListing r WHERE r.governorate = g AND r.price = (SELECT MAX(r2.price) FROM RealEstateListing r2 WHERE r2.governorate = g)) AS idRealEstateMaxPrice " +
            "FROM Governorate g " +
            "WHERE EXISTS (SELECT 1 FROM RealEstateListing r1 WHERE r1.governorate = g AND r1.price IS NOT NULL) " +
            "ORDER BY g.name ASC")
    List<Map<String, Object>> findGovernoratesWithMinMaxPrices();





}
