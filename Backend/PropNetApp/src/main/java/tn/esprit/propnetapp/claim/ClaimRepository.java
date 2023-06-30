package tn.esprit.propnetapp.claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    @Query("SELECT u from Claim u order by u.idClaim desc")
    List<Claim> getLastClaim();


}
