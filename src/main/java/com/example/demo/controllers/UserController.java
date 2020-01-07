package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping(path="/viewUsers")
	public String getUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "viewUsers";
	}
	
	@GetMapping(path="/page")
	public String getPage() {
		return "index";
	}
	
	@GetMapping(path="/add")
	public String getWelcome() {
		return "add";
	}
	
	@PostMapping(path="/add")
	public String addUser(@RequestParam String name, @RequestParam String email){

		User user = new User();
		user.setName(name);
		user.setEmail(email);		
		userRepository.save(user);
		
		return "redirect:/demo/viewUsers";
		
	}

}
