package tn.esprit.propnetapp.claim;


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
public class Claim implements Serializable {
    /**
     * ID: Long
     * Title: String
     * Description: String
     * User ID: String
     * Status: String
     * Creation Date: DateTime
     * Resolution Date: DateTime
     * Priority: String
     * Category: String
     * Attachments: List of Files
     * Assigned To: String
     * Comments: List of Strings
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClaim;
    private String title;
    private String description;
    private Date crationDate;
    private Date resolution;
    private String assignedTo;
    @ManyToOne
    private AppUser appUser;
}
