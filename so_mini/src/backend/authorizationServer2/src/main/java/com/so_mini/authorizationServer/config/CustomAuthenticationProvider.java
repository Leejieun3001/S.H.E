package com.so_mini.authorizationServer.config;

import com.so_mini.authorizationServer.model.User;
import com.so_mini.authorizationServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * jieun
 * 로그인 정보의 유효성을 검사하기 위한 것!
 * 회원 닉네임으로 DB를 조회하여 비밀번호 매칭 여부 확인
 * 없거나 비밀번호가 틀린 경우 -> Exception
 * 로그인 정보가 유효한 경우 -> 인증 정보 생성 후 return
 *
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder pwdEncoder;
    private final UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();


<<<<<<< HEAD
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user is not exists!!!!"));
        int uIdx = user.getUid();
        if (!pwdEncoder.matches(password, user.getU_pwd()))
=======
        if (!pwdEncoder.matches(password, user.getPwd()))
>>>>>>> jieun
            throw new BadCredentialsException("password is not valid!!!");
        return new UsernamePasswordAuthenticationToken(email, password, user.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
