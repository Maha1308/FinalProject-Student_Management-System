package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepo;

	//get record
	@Override
	public List<Student> fetchStudentList() {
		return studentRepo.findAll();
	}

	//update record
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Student updateStudent(Long sid, Student student) {
		Optional<Student> student1= studentRepo.findById(sid);
		Student stuDB=null;
		if(student1.isPresent()) {
			stuDB=studentRepo.findById(sid).get();
			if(Objects.nonNull(student.getSname()) && !"".equalsIgnoreCase(student.getSname())) {
				stuDB.setSname(student.getSname());
			}
			if(Objects.nonNull(student.getSage()) && !"".equals(student.getSage())) {
				stuDB.setSage(student.getSage());
				System.out.println(student.getSage());
			}
			if(Objects.nonNull(student.getSplace()) && !"".equalsIgnoreCase(student.getSplace())) {
				stuDB.setSplace(student.getSplace());
				System.out.println(student.getSplace());
			}
			if(Objects.nonNull(student.getSemail()) && !"".equalsIgnoreCase(student.getSemail())) {
				stuDB.setSemail(student.getSemail());
				System.out.println(student.getSemail());
			}
			if(Objects.nonNull(student.getSmobile()) && !"".equalsIgnoreCase(student.getSmobile())) {
				stuDB.setSmobile(student.getSmobile());
				System.out.println(student.getSmobile());
			}

		}
		return studentRepo.save(stuDB);
	}

	//delete
	@Override
	public void deleteStudentById(Long sid) {
		studentRepo.deleteById(sid);	
	}

	//get record by name
	@Override
	public Student fetchStudentByName(String sname) {
		return studentRepo.findBySname(sname);
	}

	//get record by id, if id is not present then print error message
	@Override
	public Student fetchStudentById(Long sid) throws StudentNotFoundException {
		Optional<Student> student1= studentRepo.findById(sid);//check in database
		if(!student1.isPresent()) {
			throw new StudentNotFoundException("Student not available");
		}
		return studentRepo.findById(sid).get();
	}

}
