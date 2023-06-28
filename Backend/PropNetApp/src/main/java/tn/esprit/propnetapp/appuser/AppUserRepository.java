package tn.esprit.propnetapp.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("SELECT user.address AS address, count(p.appUser.idAppUser) AS idAppUser FROM Post p JOIN p.appUser user GROUP BY user.address")
    List<Object[]> findPostWithLocation();


}
