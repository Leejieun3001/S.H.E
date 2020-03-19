package com.so_mini.security;

import com.so_mini.domain.User;
import com.so_mini.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		final User user = userRepository.findByNickname(nickname);

		if(user == null) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
		}

		return org.springframework.security.core.userdetails.User
				.withUsername(nickname)
				.password(user.getPassword())
				.authorities(user.getRoles())
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();

	}
}
