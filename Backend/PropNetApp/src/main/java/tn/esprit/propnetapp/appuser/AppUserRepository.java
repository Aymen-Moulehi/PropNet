package tn.esprit.propnetapp.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    List<AppUser> findByAddress(String address);

    @Query("SELECT u FROM AppUser u WHERE u.Name LIKE %:name% AND u.accountStatus = :accountStatus")
    List<AppUser> findUsersByNameAndAccountStatus(@Param("name") String name, @Param("accountStatus") AccountStatus accountStatus);


    List<AppUser> findByAccountStatus(AccountStatus accountStatus);




}
