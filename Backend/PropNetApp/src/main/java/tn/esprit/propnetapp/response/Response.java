package tn.esprit.propnetapp.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.propnetapp.post.Post;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponse;
    @Column(length = 10000)
    private String content;
    private String author;
    private Date responseDate;
    private String formatedDate;
    @ManyToOne
    @JsonIgnore
    private Post post;
}
