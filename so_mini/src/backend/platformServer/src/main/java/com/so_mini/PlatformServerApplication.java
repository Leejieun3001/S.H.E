package com.so_mini;


import com.so_mini.domain.model.Post;
import com.so_mini.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@SpringBootApplication
public class PlatformServerApplication {
    @Autowired
    private PostRepository postRepository;
  //  private UserRepository userRepository;


    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
               //userRepository.save(new User(1, "test","test","test","test","test","test","test","test","test",1,"test","test","test", 2,"1010"));
              //  postRepository.save(new Post(2, LocalDateTime.now(),"23","23",0,0,"23","23"));
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(PlatformServerApplication.class, args);
    }

}
