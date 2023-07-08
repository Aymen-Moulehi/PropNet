package tn.esprit.propnetapp.Jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static tn.esprit.propnetapp.appuser.AccountType.Admin;
import static tn.esprit.propnetapp.appuser.AccountType.User;
import tn.esprit.propnetapp.appuser.AppUserRepository;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@Slf4j
@EnableMethodSecurity
public class SecurityConfig {

    private final AppUserRepository repository;
    private final JwtRequestFilter jwtRequestFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/v1/auth/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/appUser/register",
                        "/appUser/login" ,
                        "/appUser/isTokenAv",
                        "/appUser/update" ,"/appUser/resetpassword" ,
                        "/appUser/checkpasscode"
                )
                .permitAll()
                .antMatchers("/appUser/logout").hasAnyAuthority(Admin.name())
                //.antMatchers(HttpMethod.POST, "/post/add-post")
                //.hasAnyRole("ADMIN", "USER") // Restrict access to authenticated users with roles ADMIN or USER
                .anyRequest().authenticated()
                .and()
                .cors().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}