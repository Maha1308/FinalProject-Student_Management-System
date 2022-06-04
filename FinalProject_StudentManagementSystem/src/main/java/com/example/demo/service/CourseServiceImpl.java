package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepo;

	//post
	@Override
	public Course SaveCourse(Course course) {
		return courseRepo.save(course);
	}

	//get record
	@Override
	public List<Course> fetchCourseList() {
		return courseRepo.findAll();
	}

	//update record
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Course updateCourse(Long cid, Course course) {
		Optional<Course> course1= courseRepo.findById(cid);
		Course crsDB=null;
		if(course1.isPresent()) {
			crsDB=courseRepo.findById(cid).get();
			if(Objects.nonNull(course.getCoursename()) && !"".equalsIgnoreCase(course.getCoursename())) {
				crsDB.setCoursename(course.getCoursename());
			}
			if(Objects.nonNull(course.getCoursefees()) && !"".equals(course.getCoursefees())) {
				crsDB.setCoursefees(course.getCoursefees());
				System.out.println(course.getCoursefees());
			}

		}
		return courseRepo.save(crsDB);
	}

	//delete
	@Override
	public void deleteCourseById(Long cid) {
		courseRepo.deleteById(cid);

	}

	//get record by name
	@Override
	public Course fetchCourseByName(String coursename) {
		return courseRepo.findByCoursename(coursename);
	}

	//get record by fees
	@Override
	public Course fetchCourseByFees(Double coursefees) {
		return courseRepo.findByCoursefees(coursefees);
	}

	//get record by id, if id is no present then print error message
	@Override
	public Course fetchCourseById(Long cid) throws CourseNotFoundException {
		//check for null
		Optional<Course> course1= courseRepo.findById(cid);//check in database
		if(!course1.isPresent()) {
			throw new CourseNotFoundException("Course not available");
		}
		return courseRepo.findById(cid).get();
	}

}

