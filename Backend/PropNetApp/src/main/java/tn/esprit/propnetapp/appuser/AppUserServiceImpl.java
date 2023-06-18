package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}