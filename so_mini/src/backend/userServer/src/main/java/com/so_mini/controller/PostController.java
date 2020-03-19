package com.so_mini.controller;

import java.util.HashMap;
import java.util.Map;

import com.so_mini.domain.Post;
import com.so_mini.jwt.JwtTokenUtil;
import com.so_mini.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PostController {

	private Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

	@Autowired
	PostRepository postRepository;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping(path = "/user/posts")
	public Map<String, Object> createPost(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws Exception {
		String token = headers.toSingleValueMap().get("Authentication");
		logger.info("token :"+token);
		String nickname = jwtTokenUtil.getUsernameFromToken(token);
		if(nickname == null) {
			throw new Exception("no nickname");
		} else {
			Post post = new Post();
			post.setLikes_cnt(0);
			post.setComent_cnt(0);
			post.setP_writer(nickname);
			post.setP_content(map.get("content"));
			post.setP_img(map.get("image"));
			// add hash tag later
			post.setP_location(map.get("location"));
			postRepository.save(post);
		}

		Map<String, Object> hashMap = new HashMap<>();
		map.put("errorcode", "10");
		return hashMap;
	}




}
