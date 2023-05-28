package tn.esprit.propnetapp.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.response.Response;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    /**
     * ID: Long
     * Title: String
     * Content: String
     * Date: Date
     * Likes: Integer
     * Comments: Array or List of Comment objects
     * Tags: Array or List of Strings
     * Image: String or URL
     * ShareCount: Integer
     * Views: Integer
     * Location: String
     * Hashtags: Array or List of Strings
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    private String title;
    private String Content;
    private Date postDate;
    private Integer likes = 0;
    @OneToMany(mappedBy = "post")
    private Collection<Response> responses;
    @ManyToOne
    private AppUser appUser;
}
