package com.valtech.training.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public UserVO register(@RequestBody UserVO uv) {
		return userService.signIn(uv);
	}
	
	@PostMapping("/")
	public UserVO login(@RequestBody UserVO uv) {
		return userService.logIn(uv);
	}
	
	@PostMapping("/")
	public UserVO changePassword(@RequestBody UserVO uv) {
		return userService.changePassword(uv);
	}
	
}
