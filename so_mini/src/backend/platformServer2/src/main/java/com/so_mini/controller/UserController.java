package com.so_mini.controller;

import java.util.Arrays;
import java.util.Map;

import com.so_mini.domain.User;
import com.so_mini.repository.UserRepository;
import com.so_mini.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.so_mini.domain.Role.ROLE_ADMIN;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@PostMapping("signup")
	public String signup(@RequestBody Map<String, String> user) {
		User tmp = new User();
		tmp.setEmail(user.get("email"));
		tmp.setName(user.get("name"));
		tmp.setNickname(user.get("nickname"));
		tmp.setPassword(passwordEncoder.encode(user.get("password")));
		tmp.setRoles(Arrays.asList(ROLE_ADMIN));

		return userService.signup(tmp);
	}

	@PostMapping("login")
	public String login(@RequestBody Map<String, String> user) {

		User member = userRepository.findByNickname(user.get("nickname"));
		if(member == null) throw new IllegalArgumentException("가입되지 않은 아이디 입니다");
		if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
			throw new IllegalArgumentException("잘못된 비밀번호입니다.");
		}
		return userService.signin(user.get("nickname"), user.get("password"));
	}

	// 로그인 결과 페이지
	@GetMapping("login/result")
	public String dispLoginResult() {
		return "/loginSuccess";
	}

	// 로그아웃 결과 페이지
	@GetMapping("logout/result")
	public String dispLogout() {
		return "/logout";
	}

	// 접근 거부 페이지
	@GetMapping("denied")
	public String dispDenied() {
		return "/denied";
	}

	// 내 정보 페이지
	@GetMapping("info")
	public String dispMyInfo() {
		return "/myinfo";
	}

}