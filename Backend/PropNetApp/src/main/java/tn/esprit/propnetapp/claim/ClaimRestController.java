package tn.esprit.propnetapp.claim;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/claim")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimRestController {
    IClaimService claimService;
    private JavaMailSender javaMailSender;

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
    @GetMapping("/getLastClaim")
    public Claim getLastClaim() {
      List<Claim> ListClaim = claimService.getLastClaimService();
        return ListClaim.get(0);
    }


    @SuppressWarnings("unused")
    @PostMapping("/confirme")
    public HashMap<String, String> verifieEmailUser(@RequestBody JSONPObject data){ System.out.println("data recived : "+data.toString());
        Claim u = getLastClaim();

        String mail = u.getEmail().toString();
        HashMap<String, String> msg = new HashMap<>();

        try {
            System.out.println(u);
            if(u!=null) {
                // send mail contient role de user
                SimpleMailMessage sender = new SimpleMailMessage();
                sender.setTo(mail);
                sender.setSubject("My-school - Recuperation Mot de passe");
                sender.setText("Salut "+u.getName()+" "+",Bienvenue sur My-school  , \n Vous êtes inscrit sous rôle de : ");
                javaMailSender.send(sender);

                msg.put("status", "success");
                msg.put("result", "E-mail envoyée avec succès");
            }else{
                msg.put("status", "warning");
                msg.put("result", "E-mail inexiste");
            }

        }catch (Exception e) {
            // TODO: handle exception
            msg.put("status", "error");
            e.printStackTrace();
        }
        return  msg ;
    }





}
