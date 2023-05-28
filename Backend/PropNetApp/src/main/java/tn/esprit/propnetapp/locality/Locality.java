package tn.esprit.propnetapp.locality;


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
    private Integer idLocality;
    private String name;
    @ManyToOne
    private Region region;
    @OneToOne(mappedBy = "locality")
    private LocalityDetail localityDetail;
}
