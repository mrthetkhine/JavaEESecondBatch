package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CourseService;
import com.example.demo.dto.CourseDto;

@RestController
@RequestMapping(path = "/api/course")
public class CourseApi {
	
	@Autowired
	CourseService courseService;
	
	 @GetMapping(produces = "application/json")
     public List<CourseDto> getAllCourse() 
     {
        return this.courseService.getAllCourse();
     }
	 @GetMapping(path="/{id}",produces = "application/json")
     public CourseDto getCourse(@PathVariable("id") Long id) 
     {
        return this.courseService.getCourseById(id);
     }    
	 @PostMapping
     public CourseDto createNewCourse(@RequestBody CourseDto courseDto) 
     {
		 System.out.println("Create New Course");
        return this.courseService.createNewCourse(courseDto);
     }
	 @PutMapping(path="/{id}")
     public CourseDto updateCourse(@PathVariable("id") Long id,@RequestBody CourseDto courseDto) 
     {
		 courseDto.setId(id);
		 System.out.println("Update  Course");
        return this.courseService.createNewCourse(courseDto);
     }
}
