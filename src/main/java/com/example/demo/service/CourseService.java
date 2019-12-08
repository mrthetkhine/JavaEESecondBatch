package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDto;

public interface CourseService {
	List<CourseDto> getAllCourse();
	CourseDto getCourseById(Long id);
	CourseDto createNewCourse(CourseDto dto);
	CourseDto updateCourse(CourseDto dto);
}
