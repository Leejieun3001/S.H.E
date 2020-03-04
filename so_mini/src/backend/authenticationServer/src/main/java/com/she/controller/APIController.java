package com.she.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.she.domain.User;
import com.she.domain.Following;
import com.she.repository.UserRepository;
import com.she.repository.FollowingRepository;

@RestController
@RequestMapping("api")
public class APIController {

	@Autowired UserRepository userRepository;
	@Autowired FollowingRepository followingRepository;

	@RequestMapping("users")
	public List<User> users() {
		return userRepository.findAll();
	}

	@RequestMapping("user/{u_idx}")
	public User user(@PathVariable("u_idx") int u_idx) {
		return userRepository.findById(u_idx).get();
	}

	@RequestMapping("followings")
	public List<Following> followings() {
		return followingRepository.findAll();
	}

}
