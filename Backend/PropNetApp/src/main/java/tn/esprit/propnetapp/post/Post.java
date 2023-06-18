package tn.esprit.propnetapp.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.response.Response;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    private String title;
    private String content;
    private Date postDate;
    private String category = "";
    private String relatedTags = "";
    private String imageUrl;
    private Integer likes = 0;
    @OneToMany(mappedBy = "post")
    private Collection<Response> responses = new ArrayList<>();
    @ManyToOne
    private AppUser appUser;
    private String status;
}
