package tn.esprit.propnetapp.appuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.Jwt.JwtUtil;
import tn.esprit.propnetapp.Jwt.LogoutService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/appUser")
public class AppUserRestController {
    private final IAppUserService appUserService;

    private final AppUserRepository appUserRepository;
    private final LogoutService logoutService;
    private final AuthenticateService authenticateService;
    private final JwtUtil jwtUtil;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticateService.register(request));
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return ResponseEntity.ok(authenticateService.authenticate(request, httpRequest, httpResponse));
    }


    @CrossOrigin
    @GetMapping("/hello")
    public ResponseEntity<?> hello(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("jwtToken") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("You need to log in");
        }
        AuthenticationResponse response = authenticateService.hello(session);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @PostMapping("/getAccount")
    public ResponseEntity<AppUser> getAccount(HttpServletRequest httpRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "http://localhost:4200");

        //log.info("----------------return token from controller getaccount{}",token);
        AuthenticationResponse response = authenticateService.getAccount(httpRequest);
        log.info("----------------return{}", ResponseEntity.ok(response.getAppUser()));
        return ResponseEntity.ok().body(response.getAppUser());
    }

    @CrossOrigin
    @PostMapping("/logout")
    public void logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Authentication request) {
        logoutService.logout(httpRequest, httpResponse, request);
    }


    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<AuthenticationResponse> updateAccount(HttpServletRequest httpRequest , @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticateService.update(httpRequest , request));
    }
    @CrossOrigin
    @PostMapping("/isTokenAv")
    public Boolean isTokenAv(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Authentication request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "http://localhost:4200");
        return authenticateService.isTokenAv(httpRequest);
    }

}


