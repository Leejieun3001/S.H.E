package com.so_mini;

import com.so_mini.domain.Board;
import com.so_mini.domain.User;
import com.so_mini.domain.enums.BoardType;
import com.so_mini.repository.BoardRepository;
import com.so_mini.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.stream.IntStream;


@SpringBootApplication
public class PlatformServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformServerApplication.class, args);
    }

}
