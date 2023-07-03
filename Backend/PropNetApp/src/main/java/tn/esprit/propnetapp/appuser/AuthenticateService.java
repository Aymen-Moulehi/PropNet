package tn.esprit.propnetapp.appuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.Jwt.JwtUtil;
import tn.esprit.propnetapp.features.email.EmailDetail;
import tn.esprit.propnetapp.features.email.EmailDetailServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final EmailDetailServiceImpl emailDetailService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthenticationResponse register(RegisterRequest request) {
        log.info("aaaaa{}",request.getName());
        var user = AppUser.builder()
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .name(request.getName())
                .biography(request.getBiography())
                .date(request.getDate())
                .claims(request.getClaims())
                .accountStatus(request.getAccountStatus())
                .creationDate(request.getCreationDate())
                .address(request.getAddress())
                .posts(request.getPosts())
                .feedbacks((request.getFeedbacks()))
                .realEstateListings(request.getRealEstateListings())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountType(AccountType.User)
                .build();
        repository.save(user);
        var jwtToken = jwtUtil.generateToken(user.getUsername());
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
        log.info("-----------------cdcdedededdc-------{}",request.getEmail());
        log.info("-----------------cdcdededdddeddc-------{}",request.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        log.info("-----------------cdcdc-------{}" );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtil.generateToken(user.getUsername());
        // Create a new session
        HttpSession session = httpRequest.getSession(true);
        Cookie tokenCookie = new Cookie("jwtToken", jwtToken);
        tokenCookie.setPath("/");
        tokenCookie.setMaxAge(3600);
        tokenCookie.setDomain("localhost");
        String cookieValue = "jwtTokenn=" + jwtToken + "; Path=/; Secure; SameSite=None";
        httpResponse.setHeader("Set-Cookie", cookieValue);
        httpResponse.addCookie(tokenCookie);
        // Store the token in the session
        session.setAttribute("jwtToken", jwtToken);
        session.setAttribute("id" , session.getId());
        session.setAttribute("email" , user.getEmail());
        return AuthenticationResponse.builder().appUser(user).token(jwtToken).build();
    }

    public AuthenticationResponse hello(HttpSession session) {
        // Retrieve the token from the session
        String token = (String) session.getAttribute("jwtToken");
        String email = (String) session.getAttribute("email");
        String userEmail = jwtUtil.extractUsername(token);
        log.info("------------------------{}" , email);
        if (token != null && jwtUtil.isTokenValid(token , userEmail)) {
            // Token is valid, perform any necessary operations
            // ...
            var user = repository.findByEmail(userEmail)
                    .orElseThrow();
            var newJwtToken = jwtUtil.generateToken(user.getUsername());

            // Update the token in the session
            session.setAttribute("jwtToken", newJwtToken);
            log.info("------------------------{}" , user.getAuthorities());
            return AuthenticationResponse.builder().token(newJwtToken).build();
        }

        throw new IllegalArgumentException("Invalid token");
    }
    public AuthenticationResponse getAccount(HttpServletRequest httpRequest ) {
        log.info("----------------------IN GETACCOUNT SERVICE--{}");
        // Retrieve the token from the session
        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        String userEmail = jwtUtil.extractUsername(token);
        log.info("------------------------{}" , token);
        if (token != null && jwtUtil.isTokenValid(token , userEmail)) {
            // Token is valid, perform any necessary operations
            // ...
            var user = repository.findByEmail(userEmail)
                    .orElseThrow();
            log.info("------------------------{}" , user.getAuthorities());
            return AuthenticationResponse.builder().appUser(user).build();
        }

        throw new IllegalArgumentException("Invalid token");
    }
    public AuthenticationResponse update(HttpServletRequest httpRequest , RegisterRequest request , HttpServletResponse httpResponse ) {
        log.info("----------------------IN update SERVICE--{}");
        // Retrieve the token from the session
        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        String userEmail = jwtUtil.extractUsername(token);
        log.info("------------------------{}" , token);
        if (token != null && jwtUtil.isTokenValid(token , userEmail)) {
            var user = repository.findByEmail(userEmail)
                    .orElseThrow();

               user.setAddress(request.getAddress());
               user.setDate(request.getDate());
               user.setBiography(request.getBiography());
               user.setAccountStatus(request.getAccountStatus());
               user.setName(request.getName());
               user.setPhoneNumber(request.getPhoneNumber());

               repository.save(user);
               log.info("------------------{}" , user.getName());
            HttpHeaders headers = new HttpHeaders();
            //headers.set("Access-Control-Allow-Origin", "http://localhost:4200");
            //httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            return AuthenticationResponse.builder().appUser(user).build();

        }

        throw new IllegalArgumentException("Invalid token");
    }



    public boolean sendpassword(HttpServletRequest httpRequest  , HttpServletResponse httpResponse ,  UserResetPassword  userResetPassword) {
        httpResponse.setHeader("Access-Control-Allow-Origin" , "http://localhost:4200");
        httpResponse.setHeader("Access-Control-Allow-Credentials" , "true");
        String code = "";
/*        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }*/
        String useremailrequest = userResetPassword.getEmail();
        log.info("token from passss{}" , useremailrequest);

        log.info("token from resilt{}" , repository.findByEmail(useremailrequest));
        if (repository.findByEmail(useremailrequest).isPresent()) {
            code = UUID.randomUUID().toString();
            AppUser user = repository.findByEmail(useremailrequest)
                    .orElseThrow();
            user.setCode(code);
            repository.save(user);
            EmailDetail emailDetail = EmailDetail.builder()
                    .recipient(useremailrequest)
                    .msgBody(code)
                    .subject("This the Code to reset your password please keep it a secret")
                    .build();
            emailDetailService.sendMail(emailDetail);
            return true;
        }
       else return false;
    }
    public String checkpasscode(HttpServletRequest httpRequest  , HttpServletResponse httpResponse ,  UserResetPassword  userResetPassword) {
        httpResponse.setHeader("Access-Control-Allow-Origin" , "http://localhost:4200");
        httpResponse.setHeader("Access-Control-Allow-Credentials" , "true");
        String code = userResetPassword.getCode();
/*        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }*/
        log.info("aaaaaaaaaaaaa{}", userResetPassword.getNewPassword());
        String useremailrequest = userResetPassword.getEmail();
        String sendedcode = userResetPassword.getCode();
        if (repository.findByEmail(useremailrequest).isPresent()) {
            AppUser appUser  = repository.findByEmail(useremailrequest).orElseThrow();;
            String usercode = appUser.getCode();
            boolean stat = sendedcode.equals(usercode);
            if (stat) {
                appUser.setPassword((passwordEncoder.encode(userResetPassword.getNewPassword())));
                repository.save(appUser);
                return "password has been set";

            } else return "wrong code";
        }
        else return "email not found";
    }

    public Boolean isTokenAv(HttpServletRequest httpRequest  , HttpServletResponse httpResponse) {
        httpResponse.setHeader("Access-Control-Allow-Origin" , "http://localhost:4200");
        httpResponse.setHeader("Access-Control-Allow-Credentials" , "true");
        Boolean Res;
        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        log.info("token from tokav{}" , token);
        if (token != ""){
        String email = jwtUtil.extractUsername(token);
        Res = jwtUtil.isTokenValid(token ,email);
        }
        else {
        Res = false;}
        return  Res;
    }

    }
