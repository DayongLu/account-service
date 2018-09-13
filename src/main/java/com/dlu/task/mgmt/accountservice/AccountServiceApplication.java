package com.dlu.task.mgmt.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initialize(AccountRepository repository){
        return args -> {

            Stream.of("Shanghai GreenVelley|BSH Nanjing").flatMap( s -> {
                return Arrays.stream(s.split("\\|"));
            }).forEach(acc ->{
                repository.save(new Account(acc));
            });


        };
    }
}
