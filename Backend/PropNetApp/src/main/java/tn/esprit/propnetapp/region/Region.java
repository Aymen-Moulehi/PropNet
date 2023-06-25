package tn.esprit.propnetapp.region;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.governorate.Governorate;
import tn.esprit.propnetapp.locality.Locality;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region implements Serializable {
    /**
     * ID: Long
     * Name: String
     * Area: Float
     * Latitude: Float
     * Longitude: Float
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;
    private String name;
    private Float area;
    private Float latitude;
    private Float longitude;
    @ManyToOne
    @JsonIgnore
    private Governorate governorate;
    @OneToMany(mappedBy = "region")
    @JsonIgnore
    private Collection<Locality> localities;
}
