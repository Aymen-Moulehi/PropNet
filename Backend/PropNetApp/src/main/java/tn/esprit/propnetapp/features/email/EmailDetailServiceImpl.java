package tn.esprit.propnetapp.features.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailDetailServiceImpl implements IEmailDetailService {

    @Autowired
    EmailDetailRepository emailDetailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    @Override
    public EmailDetail sendMail(EmailDetail details) {
        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            emailDetailRepository.save(details);
            log.info("Mail Sent Successfully...");
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            log.error("Error while Sending Mail");
        }
        return details;
    }
}