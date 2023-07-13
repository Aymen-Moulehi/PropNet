package tn.esprit.propnetapp.governorate;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.address.Address;
import tn.esprit.propnetapp.city.City;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

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
    private Integer idGovernorate;
    private String name;
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "governorate")
    private Collection<City> cities;

    @JsonIgnore
    @OneToMany(mappedBy = "governorate")
    private Collection<RealEstateListing> realEstateListings;
}
