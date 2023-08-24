package com.example.springdatamongodb.config;

import com.example.springdatamongodb.dacument.User;
import com.example.springdatamongodb.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Log4j2
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    public CommandLineRunner getRunner(UserRepository userRepository) {
        return (strings) -> {
            log.info(userRepository.save(new User(1, "naveen mishra", "GM", 130000d)));
            log.info(userRepository.save(new User(2, "Naveen Kumar Mishra", "Docunt", 53000d)));
        };
    }
}
