package tn.esprit.propnetapp.claim;


import java.util.List;

public interface IClaimService {
    Claim addClaim(Claim claim);
    List<Claim> retrieveAllClaim();
    Claim updateClaim (Claim c);

    Claim retrieveClaim (Integer idClaim);

    void deleteClaim(Integer idClaim);
    List<Claim> getLastClaimService();
}