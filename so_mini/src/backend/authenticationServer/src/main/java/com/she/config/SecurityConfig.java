package com.she.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
				.withUser("user1")
				.password("test123")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security
				.csrf().disable() // rest api이므로 csrf 보안 필요없음
				.httpBasic().disable() // rest api이므로 기본설정 안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트된다.
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증할것이므로 세션필요없으므로 생성안함.
				.and()
				//authorization 서버 세팅시 자동으로 생성되는 주소를 누구나 접근할 수 있게하기 위한 세팅
				.authorizeRequests().antMatchers("/oauth/**", "/oauth2/callback", "/h2-console/*").permitAll()
				.and()
				.formLogin().and();


	}
}