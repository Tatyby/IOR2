package com.example.ior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IorApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner runner(IorRepository repo) {
//        return args -> {
//            LocalDateTime now = LocalDateTime.now();
//
//            IncidentEntity incident = IncidentEntity.builder()
//                    .author("author")
//                    .timeCreated(now)
//                    .build();
//
//            repo.save(incident);
//
//            System.out.println(repo.findByTimeCreated(now));
//        };
//    }
}
