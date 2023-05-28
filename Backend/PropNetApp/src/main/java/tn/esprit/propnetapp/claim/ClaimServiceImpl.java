package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ClaimServiceImpl implements IClaimService {

    ClaimRepository claimRepository;

    @Override
    public Claim addClaim(Claim claim) {
        return claimRepository.save(claim);
    }
}