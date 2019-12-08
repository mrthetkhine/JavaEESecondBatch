package com.example.demo.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CourseService;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.apierror.ErrorMessage;

@RestController
@RequestMapping(path = "/api/v2/course")
public class CourseApi2 {
	
	@Autowired
	CourseService courseService;
	
	 @GetMapping(produces = "application/json")
     public ResponseEntity<List<CourseDto>> getAllCourse() 
     {
        return ResponseEntity.ok(this.courseService.getAllCourse());
     }
	 @GetMapping(path="/{id}",produces = "application/json")
     public ResponseEntity<Object> getCourse(@PathVariable("id") Long id) 
     {
		 CourseDto dto ;
		 try
		 {
			 dto = this.courseService.getCourseById(id);
			 return ResponseEntity.ok(dto);
		 }
		 catch(Exception e)
		 {
			 ErrorMessage message = new ErrorMessage();
			 
			 message.setMessage(e.getMessage());
			 message.setDescription("Cannot find course with id "+id);
			 
			 return ResponseEntity.badRequest().body(message);
		 }
        
     }    
	 @PostMapping
     public CourseDto createNewCourse(@Valid @RequestBody CourseDto courseDto) 
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
	 @DeleteMapping(path="/{id}")
     public void deleteCourse(@PathVariable("id") Long id) 
     {
		
		 System.out.println("Delete  Course");
         this.courseService.deleteCourseById(id);
     }
}
