package tn.esprit.propnetapp.Jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String jwt;
        String authorizationHeader = (String) req.getAttribute("Authorization");
        String useremail;
        // Retrieve the token from the session
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }



        if (request.getServletPath().contains("/register")) {
            filterChain.doFilter(request, response);
            return;}


        if (request.getServletPath().contains("/login")) {
            log.info("in login");
            filterChain.doFilter(request, response);
            log.info("done in login");
            return;}
        if (request.getServletPath().contains("/resetpassword")) {
            log.info("in resetpassword");
            filterChain.doFilter(request, response);
            log.info("done in resetpassword");
            return;}
        if (request.getServletPath().contains("/checkpasscode")) {
            log.info("in checkpasscode");
            filterChain.doFilter(request, response);
            log.info("done in checkpasscode");
            return;}
        if (request.getServletPath().contains("/isTokenAv")) {
            filterChain.doFilter(request, response);
            response.setHeader("Access-Control-Allow-Origin" , "http://localhost:4200");
            return;}
        if (request.getServletPath().contains("/update")) {
            filterChain.doFilter(request, response);
            return;}
        if (request.getServletPath().contains("/swagger-ui/*")) {
            filterChain.doFilter(request, response);
            return;}

        /*if (authorizationHeader == null && request.getSession().getAttribute("jwtToken")==null) {
            log.info("--------------------header null-----{}");
            filterChain.doFilter(request, response);
            return;
        }*/
        //String jtt = (String) request.getSession().getAttribute("jwtToken")
        //String tt = (String) session.getAttribute("jwtToken");
        log.info("out of filter__{}");
        useremail = jwtUtil.extractUsername(token);
        if (useremail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userService.loadUserByUsername(useremail);
            if (jwtUtil.isTokenValid(token, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        //  response.setHeader("Access-Control-Allow-Origin" , "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials" , "true");
        filterChain.doFilter(request, response);

    }
}
