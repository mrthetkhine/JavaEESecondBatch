package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long>{

}
