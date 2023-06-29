package tn.esprit.propnetapp.features.image;


import lombok.*;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImage;
    private String imageName;
    private Date imageCreationDate;
    private String imageType;
    @Column(length = 100000)
    private byte[] imageContent;
    @ManyToOne
    RealEstateListing realEstateListing;
}
