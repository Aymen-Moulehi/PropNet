package tn.esprit.propnetapp.locality;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.localitydetail.LocalityDetail;
import tn.esprit.propnetapp.region.Region;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locality implements Serializable {
    /**
     * ID: Long
     * Name: String
     * Postal Code: String
     * Latitude: Float
     * Longitude: Float
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocality;
    private String name;
    private String postalCode;
    private Float latitude;
    private Float longitude;
    @ManyToOne
    @JsonIgnore
    private Region region;
    @OneToOne(mappedBy = "locality")
    @JsonIgnore
    private LocalityDetail localityDetail;
}
