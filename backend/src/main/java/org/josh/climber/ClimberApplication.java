package org.josh.climber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClimberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimberApplication.class, args);
    }

}
