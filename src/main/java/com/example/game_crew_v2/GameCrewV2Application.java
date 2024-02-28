package com.example.game_crew_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GameCrewV2Application {

    public static void main(String[] args) {
        SpringApplication.run(GameCrewV2Application.class, args);
    }

}
