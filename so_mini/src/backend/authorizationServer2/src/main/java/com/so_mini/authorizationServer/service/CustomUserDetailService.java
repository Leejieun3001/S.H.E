package com.so_mini.authorizationServer.service;

import com.so_mini.authorizationServer.model.User;
import com.so_mini.authorizationServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userJpaRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        BCryptPasswordEncoder encoder = pwdEncoder();
        Optional<User> user = userJpaRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Name " + email + "Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),encoder.encode(user.get().getU_pwd()), getGrantedAuthorities(user));
    }
    @Bean
    private BCryptPasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Optional<User> user) {

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
        if (user.get().getGrade() == 1) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return grantedAuthority;
    }
//
//        User user = userJpaRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user is not exists!!!!!!"));
//        detailsChecker.check((UserDetails) user);
    //    return (UserDetails) user;

//    BCryptPasswordEncoder encoder = passwordEncoder();
//    @Bean
//    private BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}