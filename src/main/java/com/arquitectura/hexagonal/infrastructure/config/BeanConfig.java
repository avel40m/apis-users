package com.arquitectura.hexagonal.infrastructure.config;

import com.arquitectura.hexagonal.application.port.out.UserRepository;
import com.arquitectura.hexagonal.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
