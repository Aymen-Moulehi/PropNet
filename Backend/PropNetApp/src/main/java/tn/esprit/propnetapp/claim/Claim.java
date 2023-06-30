package tn.esprit.propnetapp.claim;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.appuser.AppUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Claim implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClaim;
    private String name;
    private String email;
   // private Date phone;
    private String sujet;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date DateCreated ;
    @JsonIgnore
    @ManyToOne
    private AppUser appUser;
}
