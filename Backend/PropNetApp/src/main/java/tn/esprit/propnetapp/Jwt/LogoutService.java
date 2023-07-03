package tn.esprit.propnetapp.Jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    log.info("cookiie --------{}" , cookie.getValue());
                    break;
                }
            }
        }
        log.info("----------tt---{}" , token);
        /* var storedToken = tokenRepository.findByToken(token);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            SecurityContextHolder.clearContext();
        }*/
        Cookie[] cookiess = request.getCookies();
        String tokens = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    tokens = cookie.getValue();
                    cookie.setValue(null); // Set the cookie value to null
                    //cookie.setMaxAge(0); // Expire the cookie immediately
                    cookie.setPath("/"); // Set the cookie path
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}