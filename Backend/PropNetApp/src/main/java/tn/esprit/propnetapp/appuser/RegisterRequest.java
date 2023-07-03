package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.propnetapp.claim.Claim;
import tn.esprit.propnetapp.feedback.Feedback;
import tn.esprit.propnetapp.post.Post;
import tn.esprit.propnetapp.realestatellisting.RealEstateListing;

import java.util.Collection;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private Gender gender;
    private String email;
    private String password;
    private String phoneNumber;
    private String address ;
    private Date date;
    private String biography;
    private AccountStatus accountStatus;
    private Date creationDate;
    private Collection<Claim> claims;
    private Collection<Post> posts;
    private Collection<Feedback> feedbacks;
    private Collection<RealEstateListing> realEstateListings;

}
