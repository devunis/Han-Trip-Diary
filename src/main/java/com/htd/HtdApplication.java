package com.htd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HtdApplication {
	public static void main(String[] args) {
		SpringApplication.run(HtdApplication.class, args);
	}
}
