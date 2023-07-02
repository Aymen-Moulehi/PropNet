package tn.esprit.propnetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PropNetAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropNetAppApplication.class, args);
    }

}
