package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/list")
	public String users(Model model)
	{
		Iterable<User> users = this.userRepository.findAll();
		
		model.addAttribute("users", users);
		System.out.println("Controller User");
		return "user/users";
	}
	@GetMapping("/new")
	public String newUser(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid User user,Errors error)
	{
		if( error.hasErrors())
		{
			System.out.println("Have Error ");
			return "user/new";
		}
		else
		{
			this.userRepository.save(user);
			return "redirect:/user/list";
		}
		
		
	}
}
