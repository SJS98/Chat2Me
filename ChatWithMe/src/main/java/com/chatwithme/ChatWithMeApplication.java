package com.chatwithme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatwithme.service.UserService;
import com.chatwithme.service.UserServiceImpl;

@SpringBootApplication
public class ChatWithMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatWithMeApplication.class, args);
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

}
