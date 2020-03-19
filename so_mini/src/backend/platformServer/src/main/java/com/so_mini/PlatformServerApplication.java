package com.so_mini;

import com.so_mini.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlatformServerApplication {
    @Autowired
    private PostRepository postRepository;


    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(PlatformServerApplication.class, args);
    }

}
