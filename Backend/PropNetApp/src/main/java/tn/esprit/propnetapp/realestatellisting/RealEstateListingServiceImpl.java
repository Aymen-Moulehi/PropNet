package tn.esprit.propnetapp.realestatellisting;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.appuser.AppUserRepository;
import tn.esprit.propnetapp.features.email.EmailDetail;
import tn.esprit.propnetapp.features.email.IEmailDetailService;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class RealEstateListingServiceImpl implements IRealEstateListingService {

    RealEstateListingRepository realEstateListingRepository;
    AppUserRepository appUserRepository;
    IEmailDetailService emailDetailService;



    @Override
    public RealEstateListing addRealEstateListing(RealEstateListing realEstateListing) {
        return realEstateListingRepository.save(realEstateListing);
    }

    @Override
    public List<RealEstateListing> retrieveAllRealEstateListings() {
        return realEstateListingRepository.findAll();
    }
    @Override
    public List<RealEstateListing> getRealEstateListingPendding() {
        return realEstateListingRepository.findByRealEstateStatus(RealEstateStatus.PENDING);
    }

    @Override
    public List<RealEstateListing> getRealEstateListingAccepted() {
        return realEstateListingRepository.findByRealEstateStatus(RealEstateStatus.APPROVED);
    }

    @Override
    public RealEstateListing getRealEstateListingById(Integer idRealEstateListing) {
        return realEstateListingRepository.findRealEstateListingByIdRealEstateListing(idRealEstateListing);
    }

    @Override
    public void deleteRealEstateListing(Integer id) {
        realEstateListingRepository.deleteById(id);
    }

    @Override
    public RealEstateListing accepteRealEstateListing(Integer id) {
        RealEstateListing _RealEstateListing = realEstateListingRepository.findById(id).get();

        _RealEstateListing.setRealEstateStatus(RealEstateStatus.APPROVED);
        realEstateListingRepository.save(_RealEstateListing);

        List<AppUser> ListUsers = appUserRepository.findByAddress(_RealEstateListing.getGovernorate().getCountry());

        for (AppUser item : ListUsers){

            TemplateMail templateMail = new TemplateMail();
            EmailDetail details = new EmailDetail();
            details.setSubject("Congratulations on Your New Home Purchase");
            details.setMsgBody(templateMail.ContentMailToRecipient(item.getName(),_RealEstateListing.getIdRealEstateListing()));
            details.setRecipient(item.getEmail());
            emailDetailService.sendMail(details);
        }

        return _RealEstateListing;
    }

    @Override
    public void sendEmailToUserSimulateur_credit(String creditAmount, String duration, String interestRate, String totalAmountToPay,String email) {
        String subject =  "SIMULATEUR DE CRÉDIT";
        String body = TemplateMailSimulateur.ContentMailToRecipient(creditAmount,duration,interestRate,totalAmountToPay);
        String recipient = email;
        emailDetailService.sendEmailWithParameters(subject,body,recipient);
    }

}