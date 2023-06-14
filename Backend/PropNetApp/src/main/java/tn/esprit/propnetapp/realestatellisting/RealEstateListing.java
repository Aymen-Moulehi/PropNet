package tn.esprit.propnetapp.realestatellisting;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import tn.esprit.propnetapp.address.Address;
import tn.esprit.propnetapp.appuser.AppUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateListing implements Serializable {
    /**
     * ID: Long
     * Title: String
     * Description: String
     * Property Type: String
     * Price: Float
     * Area: Float
     * Location: String
     * Number of Rooms: Integer
     * Number of Bathrooms: Integer
     * Number of Bedrooms: Integer
     * Floor Number: Integer
     * Is Furnished: Boolean
     * Has Parking: Boolean
     * Has Garden: Boolean
     * Has Balcony: Boolean
     * Has Pool: Boolean
     * Has Security: Boolean
     * Creation Date: DateTime
     * Contact Name: String
     * Contact Email: String
     * Contact Phone Number: String
     * Images: List of Files
     * Latitude: Float
     * Longitude: Float
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealEstateListing;
    private String date;
    private Float price;
    @Enumerated(EnumType.STRING)
    private RealEstateStatus realEstateStatus;

    @ManyToOne
    @JsonIgnore
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
    private AppUser appUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Address address;
}
