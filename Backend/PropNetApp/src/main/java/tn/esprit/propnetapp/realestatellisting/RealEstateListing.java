package tn.esprit.propnetapp.realestatellisting;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.city.City;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealEstateListing;
    private String Title;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private RealEstateStatus realEstateStatus;
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

//    @JsonIgnore
    @ManyToOne
    private Governorate governorate;
    private String address;
//    private Float Latitude;
//    private Float Longitude;
    private Integer builtYear;
    @ManyToOne
    private City city;

    @JsonIgnore
    @ManyToOne
    private AppUser appUser;
//    @OneToMany(mappedBy = "realEstateListing")
//    private Collection<Image> images;

}