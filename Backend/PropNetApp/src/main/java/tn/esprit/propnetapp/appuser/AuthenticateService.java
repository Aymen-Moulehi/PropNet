package tn.esprit.propnetapp.appuser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.Jwt.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final AppUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthenticationResponse register(RegisterRequest request) {
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
        log.info("-----------------cdcdedededdc-------{}" );
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
    public AuthenticationResponse update(HttpServletRequest httpRequest , RegisterRequest request ) {
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
               user.setGender(request.getGender());
               user.setName(request.getName());
               user.setPhoneNumber(request.getPhoneNumber());
               user.setPassword(request.getPassword());

               repository.save(user);

            return AuthenticationResponse.builder().appUser(user).build();

        }

        throw new IllegalArgumentException("Invalid token");
    }





    public Boolean isTokenAv(HttpServletRequest httpRequest) {

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

        if (token == " "){
        String email = jwtUtil.extractUsername(token);
        Res = jwtUtil.isTokenValid(token ,email);
        }
        else {
        Res = false;}
        return  Res;
    }

    }
