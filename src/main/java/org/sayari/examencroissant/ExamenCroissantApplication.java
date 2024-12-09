package org.sayari.examencroissant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenCroissantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenCroissantApplication.class, args);
    }

}
