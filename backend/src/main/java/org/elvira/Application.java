package org.elvira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
/*@ComponentScan({"org.elvira.service", "org.elvira.controller","org.elvira.repository"})*/
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}