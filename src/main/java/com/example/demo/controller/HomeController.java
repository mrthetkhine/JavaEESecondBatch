package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dao.StudentJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookDetail;
import com.example.demo.entity.StdCourse;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;

@Controller	
public class HomeController {
	
	@Autowired
	BookJpaRepository bookRepository;
	
	@Autowired
	StudentJpaRepository studentRepository;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	public void testOneToOne()
	{
		Book book = new Book();
		book.setTile("Java");
		
		BookDetail detail = new BookDetail();
		detail.setContent("Java is blah blah");
		
		book.setBookDetail(detail);
		
		this.bookRepository.save(book);
	}
	public void saveManyToMany()
	{
		Student st1 = new Student();
		st1.setName("Student 1");
		
		Student st2 = new Student();
		st2.setName("Student 2");
		
		StdCourse c1  = new StdCourse();
		c1.setName("Course1");
		
		StdCourse c2  = new StdCourse();
		c2.setName("Course 2");
		
		Set<StdCourse> courses = new HashSet<StdCourse>();
		courses.add(c1);
		courses.add(c2);
		
		st1.setCourses(courses);
		st2.setCourses(courses);
		
		this.studentRepository.save(st1);
		this.studentRepository.save(st2);
	}
	public void addCourse()
	{
		Student st1 = this.studentRepository.getOne(1L);
		
		Set<StdCourse> courses = st1.getCourses();
		StdCourse c3 = new StdCourse();
		c3.setName("Course 3");
		courses.add(c3);
		
		this.studentRepository.save(st1);
		
	}
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("message", "Hello World");
		System.out.println("Controller Home");
		
		//this.testOneToOne();
		//this.saveManyToMany();
		
		Student st1 = this.studentRepository.getOne(1L);
		model.addAttribute("student", st1);
		//this.addCourse();
		
		this.userService.getAllUser();
		this.courseService.getAllCourse();
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
