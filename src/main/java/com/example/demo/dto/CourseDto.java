package com.example.demo.dto;

import com.example.demo.entity.Course;

public class CourseDto {
	
	Long id;
	String name;
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
	public Course getEntity()
	{
		Course course= new Course();
		course.setId(this.id);
		course.setName(this.name);
		course.setDescription(this.description);
		
		return course;
	}
	
	

}
