package com.so_mini.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class APIController {
	// 메인 페이지
	@GetMapping("/")
	public String index() {
		return "/index";
	}
}
