package tn.esprit.propnetapp.address;


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
public class Address implements Serializable {
    /**
     * ID: Long
     * Description: String
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;
    private String description;
    @OneToOne(mappedBy = "address")
    private RealEstateListing realEstateListing;
    @ManyToOne
    private Governorate governorate;
}
