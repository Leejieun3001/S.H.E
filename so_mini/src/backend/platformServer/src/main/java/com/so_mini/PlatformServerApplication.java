package com.so_mini;

import com.so_mini.domain.model.User;
import com.so_mini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PlatformServerApplication {
    @Autowired
    private UserRepository userRepository;


        @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                userRepository.save(new User(1, "test","test","test","test","test","test","test","test","test","test","test","test","test", 2));
                userRepository.save(new User(2,"test2","test2","test2","test","test","test","test","test","test","test","test","test","test",10));
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(PlatformServerApplication.class, args);
    }

}
