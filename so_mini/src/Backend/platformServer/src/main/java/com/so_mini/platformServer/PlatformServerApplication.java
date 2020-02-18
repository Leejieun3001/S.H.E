package com.so_mini.platformServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링 반환 값이 자동으로 request body에 전달
@SpringBootApplication
public class PlatformServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformServerApplication.class, args);
	}

	@GetMapping //get 방식으로 받는 어노테이션
	public String HelloWorld(){
		return "Hello World,,,dklskfjlsdkfhkhk";
	}

}
