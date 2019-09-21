package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.User;

@Controller
@RequestMapping("/user")
public class UserController {

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
		}
		System.out.println("Name "+user.getName());
		System.out.println("Email "+user.getEmail());
		return "user/new";
	}
}
