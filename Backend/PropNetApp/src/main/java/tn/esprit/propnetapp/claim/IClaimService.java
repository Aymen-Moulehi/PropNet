package tn.esprit.propnetapp.claim;

import tn.esprit.propnetapp.locality.Locality;

import java.util.List;

public interface IClaimService {
    Claim addClaim(Claim claim);
    List<Claim> retrieveAllClaim();
    Claim updateClaim (Claim c);

    Claim retrieveClaim (Integer idClaim);

    void deleteClaim(Integer idClaim);

     List<Claim> getLastClaimService();
}