package tn.esprit.propnetapp.appuser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.Jwt.JwtUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}