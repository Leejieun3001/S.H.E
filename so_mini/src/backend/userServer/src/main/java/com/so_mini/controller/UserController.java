package com.so_mini.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.transaction.Transactional;


import com.so_mini.domain.Account;
import com.so_mini.domain.Token;
import com.so_mini.jwt.CustomUserDetails;
import com.so_mini.jwt.JwtTokenUtil;
import com.so_mini.repository.AccountRepository;
import com.so_mini.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping
public class UserController {

	private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationManager am;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@PostMapping(path = "/public/signup")
	public Map<String, Object> addNewUser(@RequestBody Account account) {
		String un = account.getNickname();
		Map<String, Object> map = new HashMap<>();
		System.out.println("회원가입요청 아이디: " + un + "비번: " + account.getPassword());
		if (accountRepository.findByNickname(un) == null) {
			account.setPassword(bcryptEncoder.encode(account.getPassword()));
			account.setGrade("1");
			map.put("success", true);
			accountRepository.save(account);
			return map;
		} else {
			map.put("success", false);
			map.put("message", "duplicated username");
		}
		return map;
	}

	@PostMapping(path = "/public/signin")
	public Map<String, Object> login(@RequestBody Map<String, String> m) throws DisabledException, LockedException, BadCredentialsException {
		final String nickname = m.get("nickname");
		System.out.println("닉네임:"+ m.get("nickname"));
		logger.info("test input username: " + nickname);
		try {
			am.authenticate(new UsernamePasswordAuthenticationToken(nickname, m.get("password")));
		} catch (DisabledException e){
			System.out.println("DisabledException error");
			throw e;
		} catch (LockedException e) {
			System.out.println("LockedException error");
			throw e;
		} catch (BadCredentialsException e) {
			System.out.println("BadCredentialException error");
			throw e;
		} catch (AuthenticationException e ) {
			System.out.println("AuthenticationException error");
			throw e;
		}
		final CustomUserDetails customUserDetails = userDetailsService.loadUserByUsername(nickname);
		final String accessToken = jwtTokenUtil.generateAccessToken(customUserDetails);
		final String refreshToken = jwtTokenUtil.generateRefreshToken(nickname);

		Token retok = new Token();
		retok.setUsername(nickname);
		retok.setRefreshToken(refreshToken);

		//generate Token and save in redis
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		vop.set(nickname, retok);

		logger.info("generated access token: " + accessToken);
		logger.info("generated refresh token: " + refreshToken);
		Map<String, Object> map = new HashMap<>();
		map.put("accessToken", accessToken);
		map.put("refreshToken", refreshToken);
		return map;
	}

	@Secured("ROLE_USER")
	@PostMapping(path="/user/logout")
	public ResponseEntity<?> logout(@RequestBody Map<String, String> m) {
		String username = null;
		String accessToken = m.get("accessToken");
		try {
			username = jwtTokenUtil.getUsernameFromToken(accessToken);
		} catch (IllegalArgumentException e) {} catch (ExpiredJwtException e) { //expire됐을 때
			username = e.getClaims().getSubject();
			logger.info("username from expired access token: " + username);
		}

		try {
			if (redisTemplate.opsForValue().get(username) != null) {
				redisTemplate.delete(username);
			}
		} catch (IllegalArgumentException e) {
			logger.warn("user does not exist");
		}

		logger.info(" logout ing : " + accessToken);
		redisTemplate.opsForValue().set(accessToken, true);
		redisTemplate.expire(accessToken, 10*6*1000, TimeUnit.MILLISECONDS);

		return new ResponseEntity(HttpStatus.OK);
	}

	// 로그인 유지
	@Secured("ROLE_USER")
	@PostMapping(path="/user/maintenance")
	public Map<String, Object> checker(@RequestBody Map<String, String> m) {
		String username = null;
		Map<String, Object> map = new HashMap<>();
		try {
			username = jwtTokenUtil.getUsernameFromToken(m.get("accessToken"));
		} catch (IllegalArgumentException e) {
			logger.warn("Unable to get JWT Token");
		}
		catch (ExpiredJwtException e) {
		}

		if (username != null) {
			map.put("success", true);
			map.put("username", username);
		} else {
			map.put("success", false);
		}
		return map;
	}

	@PostMapping(path="/public/refresh")
	public Map<String, Object>  requestForNewAccessToken(@RequestBody Map<String, String> m) {
		String accessToken = null;
		String refreshToken = null;
		String refreshTokenFromDb = null;
		String username = null;
		Map<String, Object> map = new HashMap<>();
		try {
			accessToken = m.get("accessToken");
			refreshToken = m.get("refreshToken");
			logger.info("access token in rnat: " + accessToken);
			try {
				username = jwtTokenUtil.getUsernameFromToken(accessToken);
			} catch (IllegalArgumentException e) {

			} catch (ExpiredJwtException e) { //expire됐을 때
				username = e.getClaims().getSubject();
				logger.info("username from expired access token: " + username);
			}

			if (refreshToken != null) { //refresh를 같이 보냈으면.
				try {
					ValueOperations<String, Object> vop = redisTemplate.opsForValue();
					Token result = (Token) vop.get(username);
					refreshTokenFromDb = result.getRefreshToken();
					logger.info("rtfrom db: " + refreshTokenFromDb);
				} catch (IllegalArgumentException e) {
					logger.warn("illegal argument!!");
				}
				//둘이 일치하고 만료도 안됐으면 재발급
				if (refreshToken.equals(refreshTokenFromDb) && !jwtTokenUtil.isTokenExpired(refreshToken)) {
					final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);
					String newtok =  jwtTokenUtil.generateAccessToken(userDetails);
					map.put("success", true);
					map.put("accessToken", newtok);
				} else {
					map.put("success", false);
					map.put("msg", "refresh token is expired.");
				}
			} else { //refresh token이 없으면
				map.put("success", false);
				map.put("msg", "your refresh token does not exist.");
			}

		} catch (Exception e) {
			throw e;
		}
		logger.info("m: " + m);
		return map;
	}
}