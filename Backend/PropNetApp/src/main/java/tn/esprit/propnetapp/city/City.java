package tn.esprit.propnetapp.city;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.governorate.Governorate;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegion;
    private String name;
    @ManyToOne
    @JsonIgnore
    private Governorate governorate;
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private Collection<RealEstateListing> realEstateListings;
}
