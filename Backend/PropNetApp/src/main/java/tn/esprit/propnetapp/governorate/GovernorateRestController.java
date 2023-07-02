package tn.esprit.propnetapp.governorate;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.appuser.AppUser;
import tn.esprit.propnetapp.appuser.AppUserRepository;
import tn.esprit.propnetapp.claim.TemplateMail.ClaimEmail;
import tn.esprit.propnetapp.features.email.IEmailDetailService;
import tn.esprit.propnetapp.governorate.Template.AlertAnnonce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@AllArgsConstructor
@RequestMapping("/governorate")
@EnableScheduling
public class GovernorateRestController {
    private static final Logger logger = LoggerFactory.getLogger(GovernorateRestController.class);

    IGovernorateService governorateService;
    GovernorateServiceImpl governorateServiceImp;
    GovernorateRepository governorateRepository;
    AppUserRepository appUserRepository;
    IEmailDetailService emailDetailService;


    @PostMapping("/add-governorate")
    public Governorate addGovernorate(@RequestBody Governorate governorate) {
        return governorateService.addGovernorate(governorate);
    }

    @GetMapping("/retrieve-all-governorates")
    public List<Governorate> getAllGovernorates() {
        return governorateService.retrieveAllGovernorates();
    }

    @GetMapping("/retrieve-governorate/{governorate-id}")
    public Governorate retrieveGovernorate(@PathVariable("governorate-id") Integer governorateId) {
        return governorateService.retrieveGovernorate(governorateId);
    }

    @DeleteMapping("/remove-governorate/{governorate-id}")
    public void removeGovernorate(@PathVariable("governorate-id") Integer governorateId) {
        governorateService.deleteGovernorate(governorateId);
    }

    @PutMapping("/update-governorate")
    public Governorate updateGovernorate(@RequestBody Governorate governorate) {
        return governorateService.updateGovernorate(governorate);
    }

    @GetMapping("/send-email-to-users-with-special-offer")
    public ResponseEntity<List<Map<String, Object>>> getGovernoratesWithMinMaxPrices() {
        List<Map<String, Object>> results = governorateRepository.findGovernoratesWithMinMaxPrices();

        List<AppUser> appUsers = appUserRepository.findAll();
        for (AppUser appUser : appUsers) {
            if (appUser.getEmail() != "") {
                String subject = "SPECIAL OFFER FOR YOU";
                String body = AlertAnnonce.ContentMailToRecipient(appUser.getName(), results);
                emailDetailService.sendEmailWithParameters(subject, body, appUser.getEmail());
            }
        }

        return ResponseEntity.ok(results);
    }


    @Scheduled(cron = "0 0 0 1 * ?") // Runs at midnight on the first day of every month
    public void getGovernoratesWithMinMaxPricesBatch() {
        logger.info("Batch job started");

        List<Map<String, Object>> results = governorateRepository.findGovernoratesWithMinMaxPrices();

        List<AppUser> appUsers = appUserRepository.findAll();
        for (AppUser appUser : appUsers) {
            if (appUser.getEmail() != "") {
                String subject = "SPECIAL OFFER FOR YOU";
                String body = AlertAnnonce.ContentMailToRecipient(appUser.getName(), results);
                emailDetailService.sendEmailWithParameters(subject, body, appUser.getEmail());
            }
        }

        logger.info("Batch job completed");
    }
}
