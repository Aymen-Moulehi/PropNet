package tn.esprit.propnetapp.localitydetail;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.locality.Locality;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Long idLocalityDetail;
    private Integer population;
    private Date updateDate;
    private Float marketPriceSquareMeter;
    private Float sitePriceSquareMeter;
    private Integer averageReview;
    @OneToOne
    @JsonIgnore
    private Locality locality;

}
