package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CourseService;
import com.example.demo.dto.CourseDto;

@RestController
@RequestMapping(path = "/api/course")
public class CourseApi {
	
	@Autowired
	CourseService courseService;
	
	 @GetMapping(path="/", produces = "application/json")
     public List<CourseDto> getAllCourse() 
     {
        return this.courseService.getAllCourse();
     }
	     

}
