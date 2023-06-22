package tn.esprit.propnetapp.appuser;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.propnetapp.claim.Claim;
import tn.esprit.propnetapp.feedback.Feedback;
import tn.esprit.propnetapp.post.Post;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements UserDetails {
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
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //private byte[] picture;
    private String biography;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Date lastLogin;
    private Date creationDate;
    @OneToMany(mappedBy = "appUser")
    private Collection<Claim> claims;
    @OneToMany(mappedBy = "appUser")
    private Collection<Post> posts;
    @OneToMany(mappedBy = "appUser")
    private Collection<Feedback> feedbacks;
    @OneToMany(mappedBy = "appUser")
    private Collection<RealEstateListing> realEstateListings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(accountType.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
