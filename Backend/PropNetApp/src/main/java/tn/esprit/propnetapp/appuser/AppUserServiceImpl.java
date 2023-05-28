package tn.esprit.propnetapp.appuser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}