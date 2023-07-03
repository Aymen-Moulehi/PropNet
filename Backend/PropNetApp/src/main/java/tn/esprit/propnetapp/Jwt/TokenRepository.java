package tn.esprit.propnetapp.Jwt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface  TokenRepository extends JpaRepository<Token, Integer> {


    Token findByToken(String token);
}

