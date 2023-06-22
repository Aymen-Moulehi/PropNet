package tn.esprit.propnetapp.appuser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.Jwt.JwtUtil;

@Service
@Slf4j
public class AppUserServiceImpl implements IAppUserService {

    private final AppUserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;


        public AppUserServiceImpl(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }




    @Override
    public AppUser registerUser(AppUser appUser) {
        return null;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }
}