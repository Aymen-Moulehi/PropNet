package tn.esprit.propnetapp.appuser;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("SELECT user.address AS address, count(p.appUser.idAppUser) AS idAppUser FROM Post p JOIN p.appUser user GROUP BY user.address")
    List<Object[]> findPostWithLocation();
    @Query("SELECT COUNT(u) AS count, u.address AS region FROM AppUser u GROUP BY u.address")
    List<Object[]> countUsersByRegion();

    @Query("SELECT COUNT(u) AS UserCount FROM AppUser u ")
    Integer countUsers();

    @Query("SELECT u FROM AppUser u ")
    List<AppUser> getAllusers();



}
