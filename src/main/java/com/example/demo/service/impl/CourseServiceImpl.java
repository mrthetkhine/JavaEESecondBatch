package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseJpaRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;

@Service
class CourseServiceImpl implements CourseService{

	@Autowired
	CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<CourseDto> getAllCourse() {
		System.out.println("Get all course");
		List<Course> courses = this.courseJpaRepository.findAll();
		
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		for(Course course : courses)
		{
			CourseDto dto = new CourseDto(course);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public CourseDto getCourseById(Long id) {
		Course course = this.courseJpaRepository.getOne(id);
		return new CourseDto(course);
	}

	@Override
	public CourseDto createNewCourse(CourseDto dto) {
		Course entity = dto.getEntity();
		Course savedEntity = this.courseJpaRepository.save(entity);
		return new CourseDto(savedEntity);
	}

}
