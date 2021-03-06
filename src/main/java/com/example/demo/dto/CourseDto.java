package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.dto.validation.ValidCourseName;
import com.example.demo.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourseDto {
	
	Long id;
	
	@NotNull
	@ValidCourseName(message="name must begin with uppercase")
	String name;
	
	@NotNull
	@Size(min=5, message="Description must be at least 5 characters long")
	String description;
	
	public CourseDto()
	{
		
	}
	
	public CourseDto(Course course)
	{
		this.id = course.getId();
		this.name = course.getName();
		this.description = course.getDescription();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public Course getEntity()
	{
		Course course= new Course();
		course.setId(this.id);
		course.setName(this.name);
		course.setDescription(this.description);
		
		return course;
	}
	
	

}
