package tn.esprit.propnetapp.feedback;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.appuser.AppUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback implements Serializable {
    /**
     * ID: Long
     * Title: String
     * Description: String
     * Rating: Integer
     * Creation Date: DateTime
     * Category: String
     * Tags: Array or List of Strings
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFeedback;
    private String name;
    private String email;
    // private Date phone;
    private String description;
    @ManyToOne
    private AppUser appUser;
}
