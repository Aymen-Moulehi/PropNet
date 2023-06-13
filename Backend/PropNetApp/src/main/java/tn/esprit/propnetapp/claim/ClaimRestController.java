package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import  java.text.SimpleDateFormat;
import java.util.List;
import java.text.ParseException;


@RestController
@AllArgsConstructor
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimRestController {
    IClaimService claimService;
    ClaimRepository claimRepository;


   /* @PostMapping("/claims")
    public Claim addClaim(@RequestBody Claim claim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String formattedDate = dateFormat.format(claim.getDateCreated());


            claim.setDateCreated(dateFormat.parse(formattedDate));
            return claimRepository.save(claim);



    }*/
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
