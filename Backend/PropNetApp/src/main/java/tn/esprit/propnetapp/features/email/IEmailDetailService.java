package tn.esprit.propnetapp.features.email;

public interface IEmailDetailService {
    EmailDetail sendMail(EmailDetail details);
     void sendEmailWithParameters(String recipient, String subject, String body);
}