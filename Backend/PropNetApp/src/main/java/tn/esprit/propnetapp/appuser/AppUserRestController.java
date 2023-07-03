package tn.esprit.propnetapp.appuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.Jwt.JwtUtil;
import tn.esprit.propnetapp.Jwt.LogoutService;
import tn.esprit.propnetapp.features.email.EmailDetail;
import tn.esprit.propnetapp.features.email.IEmailDetailService;
import tn.esprit.propnetapp.features.inputvalidator.InputValidator;
import tn.esprit.propnetapp.features.inputvalidator.ValidatorType;
import tn.esprit.propnetapp.post.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/" , allowCredentials = "true")
@RequestMapping("/appUser")
public class AppUserRestController {
    private final IAppUserService appUserService;
    IEmailDetailService emailDetailService;

    private final AppUserRepository appUserRepository;
    private final LogoutService logoutService;

    AppUserServiceImpl userService;
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
       log.info("in login controller");
        return ResponseEntity.ok(authenticateService.authenticate(request, httpRequest, httpResponse));
    }


    @PostMapping("/add-appUser")
    @CrossOrigin


    public AppUser addAppUserS(@RequestBody AppUser appUser) {
        return appUserService.addAppUser(appUser);
    }
    @CrossOrigin
    @PostMapping("/getAccount")
    public ResponseEntity<AppUser> getAccount(HttpServletRequest httpRequest) {
        log.info("in get acc");
        HttpHeaders headers = new HttpHeaders();
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
    public ResponseEntity<AuthenticationResponse> updateAccount(HttpServletRequest httpRequest ,HttpServletResponse httpResponse, @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticateService.update(httpRequest , request , httpResponse));
    }
    @CrossOrigin
    @PostMapping("/isTokenAv")
    public Boolean isTokenAv(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Authentication request) {
        return authenticateService.isTokenAv(httpRequest , httpResponse);
    }
    @CrossOrigin
    @PostMapping("/resetpassword")
    public boolean resetpassword(HttpServletRequest httpRequest, HttpServletResponse httpResponse, @RequestBody UserResetPassword userResetPassword) {

        return authenticateService.sendpassword(httpRequest , httpResponse ,userResetPassword );
    }
    @CrossOrigin
    @PostMapping("/checkpasscode")
    public String checkpasscode(HttpServletRequest httpRequest, HttpServletResponse httpResponse, @RequestBody UserResetPassword userResetPassword) {

        return authenticateService.checkpasscode(httpRequest , httpResponse ,userResetPassword );}

    @GetMapping("/user-post-withLocation")
    @CrossOrigin
    List<Map<String, Object>> findPostWithLocation() {
        return appUserService.findPostWithLocation();
    }

    
    @GetMapping("/user-by-region")
    @CrossOrigin
    public List<Map<String, Object>> getUsersCountByRegion() {
        return appUserService.getUsersByRegion();
    }

    @GetMapping("/countUser")
    @CrossOrigin
    public Integer countUsers() {
        return appUserService.countUsers();
    }

    @GetMapping("/users")
    @CrossOrigin
    public List<AppUser> getUsers(){
        return appUserRepository.getAllusers();}
    @DeleteMapping("/delete/{idAppUser}")
    @CrossOrigin
    public void deleteUser(@PathVariable("idAppUser") Integer idAppUser) {
        appUserService.deleteUser(idAppUser);
    }
    @PutMapping("/account/activate/{idAppUser}")
    @CrossOrigin
    public void activateAccount(@PathVariable("idAppUser")  Integer idAppUser) {
        appUserService.activateAccount(idAppUser);

    }
    @PutMapping("/account/deactivate/{idAppUser}")
    @CrossOrigin
    public void deactivateAccount(@PathVariable("idAppUser")  Integer idAppUser) {
        appUserService.deactivateAccount(idAppUser);
    }

    @GetMapping("/address/{address}")
    @CrossOrigin
    public List<AppUser> getUsersByAddress(@PathVariable String address) {
        return appUserService.getUsersByAddress(address);
    }


    @GetMapping("/name/{name}/status/{status}")
    public ResponseEntity<List<AppUser>> getUsersByNameAndStatus(@PathVariable("name") String name, @PathVariable("status") AccountStatus status) {
        List<AppUser> users = userService.getUserByNameAndAccountStatus(name, status);
        return ResponseEntity.ok(users);
    }



}


