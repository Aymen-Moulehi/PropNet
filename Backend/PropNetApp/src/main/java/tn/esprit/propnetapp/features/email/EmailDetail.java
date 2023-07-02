package tn.esprit.propnetapp.features.email;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmailDetail;
    private String recipient;
    private String msgBody;
    private String subject;
    private Date creationDate = new Date();
}
