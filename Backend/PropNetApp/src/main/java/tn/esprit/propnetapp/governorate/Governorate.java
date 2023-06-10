package tn.esprit.propnetapp.governorate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.address.Address;
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
    private Collection<Address> addresses;
    @OneToMany(mappedBy = "governorate")
    private Collection<Region> regions;
}
