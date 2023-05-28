package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/claim")
public class ClaimRestController {
    IClaimService claimService;

    @PostMapping("/add-claim")
    public Claim addClaimS(@RequestBody Claim claim) {
        return claimService.addClaim(claim);
    }
}
