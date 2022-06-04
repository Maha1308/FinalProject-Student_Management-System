package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	//get record by course name
	Course findByCoursename(String coursename);

	//get record by course fees
	Course findByCoursefees(Double coursefees);

}
