package com.so_mini.service;

import java.util.ArrayList;
import java.util.List;


import com.so_mini.domain.Account;
import com.so_mini.jwt.CustomUserDetails;
import com.so_mini.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Account account = accountRepository.findByNickname(nickname);

        List<GrantedAuthority> roles = new ArrayList<>();

        if (account == null) {
            throw new UsernameNotFoundException("User not found with nickname: " + nickname);
        }
        if ((account.getGrade()).equals("1")) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else roles.add(new SimpleGrantedAuthority("ROLE_HI"));

        return new CustomUserDetails(String.valueOf(account.getIdx()), account.getNickname(), account.getPassword(),roles, false );

    }

}
