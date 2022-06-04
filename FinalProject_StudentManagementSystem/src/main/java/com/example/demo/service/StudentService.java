package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;

public interface StudentService {

	//get all record
	List<Student> fetchStudentList();

	//update
	Student updateStudent(Long sid, Student student);

	//delete
	void deleteStudentById(Long sid);

	//get record by name
	Student fetchStudentByName(String sname);
	
	//get record by id, if id is not present then print error message
	Student fetchStudentById(Long sid) throws StudentNotFoundException;
	
}
