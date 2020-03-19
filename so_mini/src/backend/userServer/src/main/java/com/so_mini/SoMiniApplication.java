package com.so_mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SoMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoMiniApplication.class, args);
	}

}
