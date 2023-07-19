package tn.esprit.propnetapp.realestatellisting;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.address.Address;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.city.City;
import tn.esprit.propnetapp.features.image.Image;
import tn.esprit.propnetapp.governorate.Governorate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateListing implements Serializable {
    /**
     * ID: Long
     * Title: String
     * Description: String
     * Property Type: String
     * Price: Float
     * Area: Float
     * Location: String
     * Number of Rooms: Integer
     * Number of Bathrooms: Integer
     * Number of Bedrooms: Integer
     * Floor Number: Integer
     * Is Furnished: Boolean
     * Has Parking: Boolean
     * Has Garden: Boolean
     * Has Balcony: Boolean
     * Has Pool: Boolean
     * Has Security: Boolean
     * Creation Date: DateTime
     * Contact Name: String
     * Contact Email: String
     * Contact Phone Number: String
     * Images: List of Files
     * Latitude: Float
     * Longitude: Float
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealEstateListing;
    private String Title;
    private Date creationDate;
    private String location;
    @Enumerated(EnumType.STRING)
    private RealEstateStatus realEstateStatus;
    @JsonIgnore
    @ManyToOne
    private AppUser appUser;
    @JsonIgnore
    @OneToOne
    private Address address;
    private Float price;
    private Float area;
    @Enumerated(EnumType.STRING)
    private Operation operation;
    private Boolean realEstateIsSold;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType ;
    private Boolean hasParking;
    private Boolean hasGarden;
    private Boolean hasBalcony;
    private Boolean hasPool;
    private Boolean isFurnished;
    private Boolean hasSecurity;
    @ManyToOne
    private Governorate governorate;
    private Float Latitude;
    private Float Longitude;
    private Integer builtYear;
    private Integer floorNumber;
    @ManyToOne
    private City city;
    private String images;


}
