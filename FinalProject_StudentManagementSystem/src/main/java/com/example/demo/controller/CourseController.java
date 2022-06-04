package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseservice;

	//insert
	@PostMapping("/course/")
	public Course SaveCourse(@RequestBody Course course) {
		return courseservice.SaveCourse(course);
	}

	//get all record
	@GetMapping("/course/")
	public List<Course> fetchCourseList(){
		return courseservice.fetchCourseList();
	}

	//update record
	@PutMapping("/course/{cid}")  
	public Course updateCourse(@PathVariable ("cid") Long cid, @RequestBody Course course) {	  
		return courseservice.updateCourse(cid, course);
	}

	//delete record
	@DeleteMapping("/course/{cid}")
	public String deleteCourseById(@PathVariable("cid") Long cid) {
		courseservice.deleteCourseById(cid);
		return "Record is deleted";	
	}

	//get the record by course name
	@GetMapping("/course/coursename/{coursename}")
	public Course fetchCourseByName(@PathVariable("coursename") String coursename) {
		return courseservice.fetchCourseByName(coursename);
	}

	//get the record by course fees
	@GetMapping("/course/coursefees/{coursefees}")
	public Course fetchCourseByFees(@PathVariable("coursefees") Double coursefees) {
		return courseservice.fetchCourseByFees(coursefees);
	}

	//get record by id, if id is not present then print error message
	@GetMapping("/course/{cid}")
	public Course fetchCourseById(@PathVariable("cid") Long cid) throws CourseNotFoundException {
		return courseservice.fetchCourseById(cid);
	}


}
