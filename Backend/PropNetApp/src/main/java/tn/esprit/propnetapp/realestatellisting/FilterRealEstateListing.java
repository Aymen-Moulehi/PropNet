package tn.esprit.propnetapp.realestatellisting;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class FilterRealEstateListing {
    @PersistenceContext
    private EntityManager entityManager;
    public List<RealEstateListing> filterRealEstateListings(@Param("government") String government,
                                                            @Param("region") String region,
                                                            @Param("maxPrice") Float maxPrice,
                                                            @Param("minArea") Float minArea,
                                                            @Param("operation") Operation operation,
                                                            @Param("numberOfBedrooms") Integer numberOfBedrooms) {
        String queryStr = "SELECT a FROM RealEstateListing a " +
                "JOIN a.address ad ";

        if (government != null) {
            queryStr += "JOIN ad.governorate gov ";
            if (region != null) {
                queryStr += "JOIN gov.regions r ";
            }
        }

        if (operation != null) {
            queryStr += "WHERE a.operation = :operation ";
        }
        if (government != null) {
            queryStr += "AND gov.name = :government ";
            if (region != null) {
                queryStr += "AND r.name = :region ";
            }
        }
        if (minArea != null) {
            queryStr += "AND a.area >= :minArea ";
        }
        if (maxPrice != null) {
            queryStr += "AND a.price <= :maxPrice ";
        }
        if (numberOfBedrooms != null) {
            queryStr += "AND a.numberOfBedrooms = :numberOfBedrooms ";
        }

        queryStr += "AND a.realEstateStatus = 'APPROVED' ";
        queryStr += "AND a.realEstateIsSold = false ";

        TypedQuery<RealEstateListing> query = entityManager.createQuery(queryStr, RealEstateListing.class);
        if (government != null) {
            query.setParameter("government", government);
        }
        if (region != null) {
            query.setParameter("region", region);
        }
        if (operation != null) {
            query.setParameter("operation", operation);
        }
        if (minArea != null) {
            query.setParameter("minArea", minArea);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        if (numberOfBedrooms != null) {
            query.setParameter("numberOfBedrooms", numberOfBedrooms);
        }

        return query.getResultList();
    }
    public List<RealEstateListing> advancedFilterAnnouncements(@Param("government") String government,
                                                            @Param("region") String region,
                                                            @Param("maxPrice") Float maxPrice,
                                                            @Param("minArea") Float minArea,
                                                            @Param("operation") Operation operation,
                                                            @Param("numberOfBedrooms") Integer numberOfBedrooms,
                                                               @Param("propertyType") PropertyType propertyType,
                                                               @Param("hasBalcony") Boolean hasBalcony,
                                                               @Param("hasGarden") Boolean hasGarden,
                                                               @Param("hasParking") Boolean hasParking,
                                                               @Param("hasPool") Boolean hasPool) {

        String queryStr = "SELECT a FROM RealEstateListing a " +
                "JOIN a.address ad ";

        if (government != null) {
            queryStr += "JOIN ad.governorate gov ";
            if (region != null) {
                queryStr += "JOIN gov.regions r ";
            }
        }

        if (operation != null) {
            queryStr += "WHERE a.operation = :operation ";
        }
        if (propertyType != null) {
            queryStr += "AND a.propertyType = :propertyType ";
        }
        if (government != null) {
            queryStr += "AND gov.name = :government ";
            if (region != null) {
                queryStr += "AND r.name = :region ";
            }
        }
        if (minArea != null) {
            queryStr += "AND a.area >= :minArea ";
        }
        if (maxPrice != null) {
            queryStr += "AND a.price <= :maxPrice ";
        }
        if (numberOfBedrooms != null) {
            queryStr += "AND a.numberOfBedrooms = :numberOfBedrooms ";
        }
        if (hasParking != null) {
            queryStr += "AND a.hasParking = :hasParking ";
        }
        if (hasGarden != null) {
            queryStr += "AND a.hasGarden = :hasGarden ";
        }
        if (hasPool != null) {
            queryStr += "AND a.hasPool = :hasPool ";
        }
        if (hasBalcony != null) {
            queryStr += "AND a.hasBalcony = :hasBalcony ";
        }

        queryStr += "AND a.realEstateStatus = 'APPROVED' ";
        queryStr += "AND a.realEstateIsSold = false ";

        TypedQuery<RealEstateListing> query = entityManager.createQuery(queryStr, RealEstateListing.class);
        if (government != null) {
            query.setParameter("government", government);
        }
        if (region != null) {
            query.setParameter("region", region);
        }
        if (operation != null) {
            query.setParameter("operation", operation);
        }
        if (minArea != null) {
            query.setParameter("minArea", minArea);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        if (numberOfBedrooms != null) {
            query.setParameter("numberOfBedrooms", numberOfBedrooms);
        }
        if (propertyType != null) {
            query.setParameter("propertyType", propertyType);
        }
        if (hasBalcony != null) {
            query.setParameter("hasBalcony", hasBalcony);
        }
        if (hasParking != null) {
            query.setParameter("hasParking", hasParking);
        }
        if (hasGarden != null) {
            query.setParameter("hasGarden", hasGarden);
        }
        if (hasPool != null) {
            query.setParameter("hasPool", hasPool);
        }

        return query.getResultList();
    }
}
