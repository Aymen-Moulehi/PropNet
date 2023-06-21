package tn.esprit.propnetapp.features.email;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.features.inputvalidator.InputValidator;
import tn.esprit.propnetapp.features.inputvalidator.ValidatorType;

@RestController
@AllArgsConstructor
@RequestMapping("/emailDetail")
public class EmailDetailRestController {
    IEmailDetailService emailDetailService;
    @PostMapping("/sendMail")
    public EmailDetail sendMail(@RequestBody EmailDetail details) {
        if(!InputValidator.getInstance().validateInput(details.getRecipient(), ValidatorType.EMAIL))
            throw new IllegalArgumentException();
        if(!InputValidator.getInstance().validateInput(details.getSubject(), ValidatorType.MIN10CHAR))
            throw new IllegalArgumentException();
        if(!InputValidator.getInstance().validateInput(details.getMsgBody(), ValidatorType.MIN10CHAR))
            throw new IllegalArgumentException();
        return emailDetailService.sendMail(details);
    }
}
