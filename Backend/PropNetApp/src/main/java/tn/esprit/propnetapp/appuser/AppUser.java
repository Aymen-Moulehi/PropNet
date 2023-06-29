package tn.esprit.propnetapp.appuser;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.claim.Claim;
import tn.esprit.propnetapp.feedback.Feedback;
import tn.esprit.propnetapp.post.Post;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements Serializable {
    /**
     * Name: String
     * Age: Integer
     * Email: String
     * Address: String
     * Phone Number: String
     * Username: String
     * Password: String
     * Date of Birth: Date
     * Gender: String
     * Profile Picture: Image
     * Biography: String
     * Account Status: String
     * Last Login: DateTime
     * Creation Date: DateTime
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppUser;
    private String Name;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private Date date;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Gender gender;
    private String picture;
    private String biography;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private AccountType accountType;
    private Date lastLogin;
    private Date creationDate;
    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private Collection<Claim> claims;
    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private Collection<Post> posts;
    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private Collection<Feedback> feedbacks;
    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private Collection<RealEstateListing> realEstateListings;

    @Override
    public String toString() {
        return "AppUser{" +
                "idAppUser=" + idAppUser +
                ", address='" + address + '\'' +
                '}';
    }


}
