package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentservice;

	//get all record
	@GetMapping("/student/")
	public List<Student> fetchStudentList(){
		return studentservice.fetchStudentList();
	}

	//update record
	@PutMapping("/student/{sid}")  
	public Student updateStudent(@PathVariable ("sid") Long sid, @RequestBody Student student) {	  
		return studentservice.updateStudent(sid, student);
	}

	//delete record
	@DeleteMapping("/student/{sid}")
	public String deleteStudentById(@PathVariable("sid") Long sid) {
		studentservice.deleteStudentById(sid);
		return "Record is deleted";	
	}

	//get the record by name
	@GetMapping("/student/sname/{sname}")
	public Student fetchStudentByName(@PathVariable("sname") String sname) {
		return studentservice.fetchStudentByName(sname);
	}

	//get record by id, if id is not present then print error message
	@GetMapping("/student/{sid}")
	public Student fetchStudentById(@PathVariable("sid") Long sid) throws StudentNotFoundException {
		return studentservice.fetchStudentById(sid);
	}

}


