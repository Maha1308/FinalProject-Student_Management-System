package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.error.CourseNotFoundException;

public interface CourseService {

	//post 
	Course SaveCourse(Course course);

	//get record
	List<Course> fetchCourseList();

	//delete
	void deleteCourseById(Long cid);

	//update
	Course updateCourse(Long cid, Course course);

	//get record by name
	Course fetchCourseByName(String coursename);

	//get record by fees
	Course fetchCourseByFees(Double coursefees);

	//get record by id, if id is not present then print error message
	Course fetchCourseById(Long cid) throws CourseNotFoundException;

}
