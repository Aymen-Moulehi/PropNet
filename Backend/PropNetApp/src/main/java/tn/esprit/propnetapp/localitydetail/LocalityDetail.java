package tn.esprit.propnetapp.localitydetail;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.locality.Locality;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityDetail implements Serializable {
    /**
     * ID: Long
     * Population: String
     * Update date: Date
     * Market price square meter: Float
     * Site price square meter: Float
     * Average review: int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocalityDetail;
    private Integer population;
    @OneToOne
    private Locality locality;

}
