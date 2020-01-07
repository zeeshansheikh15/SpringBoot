package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepsitory;

@Controller
@RequestMapping(path="/demo")
public class UserController {
	
	@Autowired
	private UserRepsitory userRepository;
	
	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/page")
	public String getPage() {
		return "index";
	}
	
	@GetMapping(path="/welcome")
	public String getWelcome() {
		return "welcome";
	}
	
	@PostMapping(path="/add")
	public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email){

		User user = new User();
		user.setName(name);
		user.setEmail(email);		
		userRepository.save(user);
		
		return "saved";
		
	}

}
