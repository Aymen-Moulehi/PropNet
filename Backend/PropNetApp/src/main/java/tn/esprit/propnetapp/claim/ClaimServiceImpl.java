package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Claim> retrieveAllClaim() {
        return claimRepository.findAll();
    }

    @Override
    public Claim updateClaim(Claim c) {

        return claimRepository.save(c);
    }

    @Override
    public Claim retrieveClaim(Integer idClaim) {
        return claimRepository.findById(idClaim).get();
    }

    @Override
    public void deleteClaim(Integer idClaim) {
        claimRepository.deleteById(idClaim);

    }

    @Override
    public List<Claim> getLastClaimService() {
        return claimRepository.getLastClaim();
    }


}