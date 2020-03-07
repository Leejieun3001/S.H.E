package com.she.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		// 활성화 및 설정이 가능하고 선택적으로 인메모리 사용자 저장소에 값을 채울 수 있음
		auth.inMemoryAuthentication()
				.withUser("user")
				.password("pass")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security
				.csrf().disable()
				.headers().frameOptions().disable()
				.and()
				//authorization 서버 세팅시 자동으로 생성되는 주소를 누구나 접근할 수 있게하기 위한 세팅
				.authorizeRequests().antMatchers("/oauth/**", "/oauth2/callback", "/h2-console/*").permitAll()
				.and()
				.formLogin().and()
				.httpBasic();
	}
}