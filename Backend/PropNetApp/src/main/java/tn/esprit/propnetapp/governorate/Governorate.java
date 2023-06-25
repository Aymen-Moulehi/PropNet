package tn.esprit.propnetapp.governorate;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.address.Address;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;
import tn.esprit.propnetapp.region.Region;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Governorate implements Serializable {
    /**
     * ID: Long
     * Name: String
     * Country: String
     * Population: Integer
     * Area: Float
     * Time Zone: String
     * Mayor: String
     * Latitude: Float
     * Longitude: Float
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGovernorate;
    private String name;
    private String country;
    private Integer population;
    private Float area;
    private String timeZone;
    private String mayor;
    private Float latitude;
    private Float longitude;
    @OneToMany(mappedBy = "governorate")
    @JsonIgnore
    private Collection<Address> addresses;
    @OneToMany(mappedBy = "governorate")
    @JsonIgnore
    private Collection<Region> regions;

    @OneToMany(mappedBy = "governorate")
    @JsonIgnore
    private Collection<RealEstateListing> realEstateListings;
}
