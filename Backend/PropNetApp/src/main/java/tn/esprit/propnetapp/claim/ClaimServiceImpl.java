package tn.esprit.propnetapp.claim;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.appuser.TemplateMail.UserAccountActive;
import tn.esprit.propnetapp.claim.TemplateMail.ClaimEmail;
import tn.esprit.propnetapp.features.email.IEmailDetailService;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ClaimServiceImpl implements IClaimService {

    ClaimRepository claimRepository;
    IEmailDetailService emailDetailService;

    @Override
    public Claim addClaim(Claim claim) {
        String subject =  claim.getSubject();
        String body = ClaimEmail.ContentMailToRecipient(claim.getName());
        String recipient = claim.getEmail();
        emailDetailService.sendEmailWithParameters(subject,body,recipient);

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