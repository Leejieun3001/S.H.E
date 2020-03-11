package com.so_mini.authorizationServer.repo;


import com.so_mini.authorizationServer.model.User;
import com.so_mini.authorizationServer.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepoTest {
    @Autowired
    private UserRepository userJpaRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insert() {
        // given
        userJpaRepo.save(User.builder()
                .email("happydaddy@gmail.com")
                .pwd(passwordEncoder.encode("{none}1234"))
                .name("happydaddy")
                .build());
    }
}