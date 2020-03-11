package com.so_mini.authorizationServer.encoding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncodingTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void encodeTest() {
        System.out.printf("testSecret : %s", passwordEncoder.encode("testSecret"));
        System.out.printf("1234 : %s", passwordEncoder.encode("1234"));
        System.out.println();
    }
}

