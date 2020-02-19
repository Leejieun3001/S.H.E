package com.so_mini.platformServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PlatformServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformServerApplication.class, args);
	}

	@GetMapping
	public String HelloWorld(){
		return "Hello jieun";
	}

}
