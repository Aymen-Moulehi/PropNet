package tn.esprit.propnetapp.realestatellisting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Slf4j
public class FilterRealEstateListing {
    @PersistenceContext
    private EntityManager entityManager;

    /*  public List<RealEstateListing> filterRealEstateListings(String government,
                                                              String city,
                                                              Float maxPrice,
                                                              Integer numberOfBedrooms) {
          String queryStr = "SELECT a FROM RealEstateListing a " +
                  "JOIN a.address ad ";

          if (government != null) {
              queryStr += "JOIN ad.governorate gov ";
              if (city != null) {
                  queryStr += "JOIN gov.regions r ";
              }
          }

          if (operation != null) {
              queryStr += "WHERE a.operation = :operation ";
          }
          if (government != null) {
              queryStr += "AND gov.name = :government ";
              if (city != null) {
                  queryStr += "AND r.name = :region ";
              }
          }
          if (propertyType != null) {
              queryStr += "AND a.propertyType = :propertyType ";
          }
          if (maxPrice != null) {
              queryStr += "AND a.price <= :maxPrice ";
          }
          if (numberOfBedrooms != null) {
              queryStr += "AND a.numberOfBedrooms >= :numberOfBedrooms ";
          }

          queryStr += "AND a.realEstateStatus = 'APPROVED' ";
          queryStr += "AND a.realEstateIsSold = false ";

          TypedQuery<RealEstateListing> query = entityManager.createQuery(queryStr, RealEstateListing.class);
          if (government != null) {
              query.setParameter("government", government);
          }
          if (city != null) {
              query.setParameter("region", city);
          }
          if (operation != null) {
              query.setParameter("operation", operation);
          }
          if (propertyType != null) {
              query.setParameter("propertyType", propertyType);
          }
          if (maxPrice != null) {
              query.setParameter("maxPrice", maxPrice);
          }
          if (numberOfBedrooms != null) {
              query.setParameter("numberOfBedrooms", numberOfBedrooms);
          }

          return query.getResultList();
      }*/
    public List<RealEstateListing> advancedFilterAnnouncements(String governorate,
                                                               String city,
                                                               Float maxPrice,
                                                               Float minArea,
                                                               Operation operation,
                                                               Integer numberOfBedrooms,
                                                               Integer numberOfBathrooms,
                                                               PropertyType propertyType,
                                                               Boolean hasBalcony,
                                                               Boolean hasGarden,
                                                               Boolean hasParking,
                                                               Boolean hasPool,
                                                               Boolean hasSecurity,
                                                               Boolean isFurnished,
                                                               Integer builtYear,
                                                               Integer floorNumber,
                                                               String orderBy) {

        String queryStr = "SELECT a FROM RealEstateListing a " ;

        if (governorate != null) {
            queryStr += "JOIN a.governorate gov ";
        }
        if (city != null) {
            queryStr += "JOIN a.city c ";

        }


        if (operation != null) {
            queryStr += "WHERE a.operation = :operation ";
        } else {
            queryStr += "WHERE (a.operation = 'RENT' OR a.operation = 'SALE') ";
        }
        if (propertyType != null) {
            queryStr += "AND a.propertyType = :propertyType ";
        }
        if (governorate != null) {
            queryStr += "AND gov.name = :governorate ";
        }
        if (city != null) {
            queryStr += "AND c.name = :city ";

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
        if (numberOfBathrooms != null) {
            queryStr += "AND a.numberOfBathrooms = :numberOfBathrooms ";
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
        if (hasSecurity != null) {
            queryStr += "AND a.hasSecurity = :hasSecurity ";
        }
        if (isFurnished != null) {
            queryStr += "AND a.isFurnished = :isFurnished ";
        }
        if (builtYear != null) {
            queryStr += "AND a.builtYear = :builtYear ";
        }
        if (floorNumber != null) {
            queryStr += "AND a.floorNumber = :floorNumber ";
        }

        queryStr += "AND a.realEstateStatus = 'APPROVED' ";
        queryStr += "AND a.realEstateIsSold = false ";

        if (orderBy != null) {
            if (orderBy.equals("Low Price")) {
                queryStr += "order by a.price ";
            }
            if (orderBy.equals("High Price")) {
                queryStr += "order by a.price desc ";
            }
        }

        TypedQuery<RealEstateListing> query = entityManager.createQuery(queryStr, RealEstateListing.class);
        if (governorate != null) {
            query.setParameter("governorate", governorate);
        }
        if (city != null) {
            query.setParameter("city", city);
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
        if (numberOfBathrooms != null) {
            query.setParameter("numberOfBathrooms", numberOfBathrooms);
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
        if (hasSecurity != null) {
            query.setParameter("hasSecurity", hasSecurity);
        }
        if (isFurnished != null) {
            query.setParameter("isFurnished", isFurnished);
        }
        if (builtYear != null) {
            query.setParameter("builtYear", builtYear);
        }
        if (floorNumber != null) {
            query.setParameter("floorNumber", floorNumber);
        }
        log.info("*******************{}", queryStr);


        return query.getResultList();
    }
}
