package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookDetail;

@Controller	
public class HomeController {
	
	@Autowired
	BookJpaRepository bookRepository;
	
	public void testOneToOne()
	{
		Book book = new Book();
		book.setTile("Java");
		
		BookDetail detail = new BookDetail();
		detail.setContent("Java is blah blah");
		
		book.setBookDetail(detail);
		
		this.bookRepository.save(book);
	}
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("message", "Hello World");
		System.out.println("Controller Home");
		return "home";
	}
	/*
	@GetMapping("/user")
	public String user(Model model)
	{
		User user = new User();
		user.setName("TK");
		user.setEmail("mail@gmail.com");
		
		model.addAttribute("user", user);
		System.out.println("Controller User");
		return "user";
	}
	@GetMapping("/users")
	public String users(Model model)
	{
		List<User> users = new ArrayList<User>();
		
		User user = new User();
		user.setName("TK");
		user.setEmail("mail@gmail.com");
		
		users.add(user);
		
		User userTwo = new User();
		userTwo.setName("User Two");
		userTwo.setEmail("usertwo@gmail.com");
		
		users.add(userTwo);
		
		model.addAttribute("users", users);
		System.out.println("Controller User");
		return "users";
	}
	*/
}
