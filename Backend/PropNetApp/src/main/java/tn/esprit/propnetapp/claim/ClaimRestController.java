package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimRestController {
    IClaimService claimService;
    ClaimRepository claimRepository;

    @PostMapping("/add-claim")
    public Claim addClaimS(@RequestBody Claim claim) {
        claim.setDateCreated(new Date());
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Integer id, @RequestBody Claim updatedClaim) {
        Claim existingClaim = claimRepository.findById(id).get();

        if (existingClaim == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the properties of existingClaim with the values from updatedClaim
        existingClaim.setName(updatedClaim.getName());
        existingClaim.setEmail(updatedClaim.getEmail());
        existingClaim.setSubject(updatedClaim.getSubject());
        existingClaim.setMessage(updatedClaim.getMessage());
        existingClaim.setDateCreated(updatedClaim.getDateCreated());
        existingClaim.setAppUser(updatedClaim.getAppUser());

        Claim claim = claimService.updateClaim(existingClaim);

        return new ResponseEntity<>(claim, HttpStatus.OK);
    }
    @GetMapping("/getLastClaim")
    public Claim getLastClaim() {
        List<Claim> ListClaim = claimService.getLastClaimService();
        return ListClaim.get(0);
    }


}
