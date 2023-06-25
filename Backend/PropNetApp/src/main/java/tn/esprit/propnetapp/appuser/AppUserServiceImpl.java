package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.post.Post;

import java.util.*;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class AppUserServiceImpl implements IAppUserService {

    AppUserRepository appUserRepository;

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public List<Map<String, Object>> findPostWithLocation() {
        List<Object[]> results = appUserRepository.findPostWithLocation();

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
        appUserRepository.save(_appUser);
    }

    @Override
    public void deactivateAccount(Integer idAppUser) {
        AppUser _appUser = appUserRepository.findById(idAppUser).get();
        _appUser.setAccountStatus(AccountStatus.NOT_ACTIVE);
        appUserRepository.save(_appUser);
    }


    public List<AppUser> getUsersByAddress(String address) {
        return appUserRepository.findByAddress(address);
    }


}