package tn.esprit.propnetapp.appuser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.Jwt.JwtUtil;
import tn.esprit.propnetapp.appuser.TemplateMail.UserAccountActive;
import tn.esprit.propnetapp.appuser.TemplateMail.UserAccountDesactivate;
import tn.esprit.propnetapp.features.email.EmailDetail;
import tn.esprit.propnetapp.features.email.IEmailDetailService;

import java.util.*;

@Service
@Slf4j
public class AppUserServiceImpl implements IAppUserService {

    private final AppUserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;


        public AppUserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = appUserRepository;
            this.passwordEncoder = passwordEncoder;
        }


    AppUserRepository appUserRepository;
    IEmailDetailService emailDetailService;

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return userRepository.save(appUser);
    }



    @Override
    public List<Map<String, Object>> findPostWithLocation() {
        List<Object[]> results = userRepository.findPostWithLocation();

        List<Map<String, Object>> keyValueList = new ArrayList<>();

        for (Object[] result : results) {
            String address = (String) result[0];
            Long idAppUser = (Long) result[1];

            Map<String, Object> keyValue = new HashMap<>();
            keyValue.put("key", address);
            keyValue.put("value", idAppUser);

            keyValueList.add(keyValue);
        }

        return keyValueList;

    }

    @Override
    public List<Map<String, Object>> getUsersByRegion() {
        List<Object[]> results = appUserRepository.countUsersByRegion();

        List<Map<String, Object>> userCountByRegion = new ArrayList<>();
        for (Object[] result : results) {
            Long count = (Long) result[0];
            String region = (String) result[1];
            Map<String, Object> entry = new LinkedHashMap<>();
            entry.put("value", count);
            entry.put("key", region);

            userCountByRegion.add(entry);
        }

        return userCountByRegion;
    }

    @Override
    public Integer countUsers() {
        return appUserRepository.countUsers();
    }

    @Override
    public List<AppUser> getAllusers() {
        return appUserRepository.findAll();
    }

    @Override
    public void deleteUser(Integer idAppUser) {
         appUserRepository.deleteById(idAppUser);
    }

    @Override
    public void activateAccount(Integer idAppUser) {
        AppUser _appUser = appUserRepository.findById(idAppUser).get();
        _appUser.setAccountStatus(AccountStatus.ACTIVE);
        UserAccountActive userAccountActive = new UserAccountActive();
        EmailDetail details = new EmailDetail();
        details.setSubject("Notification: Account Activate");
        details.setMsgBody(userAccountActive.ContentMailToRecipient(_appUser.getName()));
        details.setRecipient(_appUser.getEmail());
        emailDetailService.sendMail(details);
        appUserRepository.save(_appUser);
    }

    @Override
    public void deactivateAccount(Integer idAppUser) {
        AppUser _appUser = appUserRepository.findById(idAppUser).get();
        _appUser.setAccountStatus(AccountStatus.NOT_ACTIVE);
        UserAccountDesactivate userAccountDesactivate = new UserAccountDesactivate();
        EmailDetail details = new EmailDetail();
        details.setSubject("Notification: Account Deactivation");
        details.setMsgBody(userAccountDesactivate.ContentMailToRecipient(_appUser.getName()));
        details.setRecipient(_appUser.getEmail());
        emailDetailService.sendMail(details);
        appUserRepository.save(_appUser);
    }


    public List<AppUser> getUsersByAddress(String address) {
        return appUserRepository.findByAddress(address);
    }

    public List<AppUser> getUserByNameAndAccountStatus(String name, AccountStatus accountStatus) {
        return appUserRepository.findUsersByNameAndAccountStatus(name, accountStatus);
    }



}