package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserSearchDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public String users(Model model)
	{
		List<UserDto> users = this.userService.getAllUser();
		
		model.addAttribute("users", users);
		System.out.println("Controller User list");
		
		this.userService.updateName("TK", 1L);
		return "user/users";
	}
	@GetMapping("/new")
	public String newUser(Model model)
	{
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid UserDto user,Errors error)
	{
		if( error.hasErrors())
		{
			System.out.println("Have Error ");
			return "user/new";
		}
		else
		{
			this.userService.save(user);
			
			return "redirect:/user/list";
		}
		
		
	}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id,Model model)
	{
		System.out.println("User id in eidt "+id);
		UserDto user = this.userRepository.findOne(id);
		model.addAttribute("user", user);
		return "user/new";
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		System.out.println("User id in delete "+id);
		this.userService.deleteById(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/searchUser")
	public String searchUser(Model model)
	{
		UserSearchDto search = new UserSearchDto();
		model.addAttribute("search", search);
		return "user/searchUser";
	}
	
	@PostMapping("/searchUser")
	public String searchUserPost(UserSearchDto search,Model model)
	{
		System.out.println("Search name "+search.getName());
		UserSearchDto param = new UserSearchDto();
		model.addAttribute("search", param);
		
		List<UserDto> users = this.userService.searchUserByName(search.getName());
		
		model.addAttribute("users", users);
		return "user/searchUser";
	}
}
