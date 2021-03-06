package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.CourseJpaRepository;
import com.example.demo.dao.UserJpaRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserSearchDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	CourseJpaRepository courseRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/list")
	public String users(Model model)
	{
		List<UserDto> users = this.userService.getAllUser();
		
		model.addAttribute("users", users);
		System.out.println("Controller User list");
		
		//this.userService.updateName("TK", 1L);
		//User user1 = this.userJpaRepository.getOne(12L);
		//this.userJpaRepository.delete(user1);
		
		return "user/users";
	}
	@GetMapping("/new")
	public String newUser(Model model)
	{
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		
		List<CourseDto> courses = this.courseService.getAllCourse();
		model.addAttribute("courses", courses);
		
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid UserDto user,Errors error)
	{
		System.out.println("New user post course Id "+user.getCourseId());
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
		UserDto user = this.userService.findById(id);
		model.addAttribute("user", user);
		
		List<CourseDto> courses = this.courseService.getAllCourse();
		model.addAttribute("courses", courses);
		
		System.out.println("Edit Course id "+ user.getCourseId());
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
	@GetMapping("/searchUserByNameOrEmail")
	public String searchUserByNameOrEmail(Model model)
	{
		UserSearchDto search = new UserSearchDto();
		model.addAttribute("search", search);
		return "user/searchUserByNameOrEmail";
	}
	@PostMapping("/searchUserByNameOrEmail")
	public String searchUserByNameOrEmailPost(UserSearchDto search,Model model)
	{
		System.out.println("Search name "+search.getName());
		System.out.println("Search Email "+search.getEmail());
		UserSearchDto param = new UserSearchDto();
		model.addAttribute("search", param);
		
		List<UserDto> users = this.userService.searchUserByNameOrEmail(search);
		
		model.addAttribute("users", users);
		return "user/searchUserByNameOrEmail";
	}
}
