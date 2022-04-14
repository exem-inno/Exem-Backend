package com.backend;

import com.backend.config.AppProperties;
import com.backend.model.Domain;
import com.backend.repository.ProductRepository;
import com.backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@EnableConfigurationProperties({AppProperties.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
