package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimRestController {
    IClaimService claimService;

    @PostMapping("/add-claim")
    public Claim addClaimS(@RequestBody Claim claim) {
        return claimService.addClaim(claim);
    }

    @GetMapping("/retrieveAllClaim")
    public List<Claim> getClaims() {
        List<Claim> listClaims = claimService.retrieveAllClaim();
        return listClaims;
    }
    @GetMapping("/retrieve-claim/{claim-id}")
    public Claim retrieveClaim(@PathVariable("claim-id")  Integer idClaim) {
        return claimService.retrieveClaim(idClaim);
    }
    @DeleteMapping("/delete-claim/{claim-id}")
    public void deleteCllaim(@PathVariable("claim-id") Integer idClaim) {

        claimService.deleteClaim(idClaim);
    }
    @PutMapping("/update-claim")
    public Claim updateClaim(@RequestBody Claim claim) {

        return claimService.updateClaim(claim);
    }

}
