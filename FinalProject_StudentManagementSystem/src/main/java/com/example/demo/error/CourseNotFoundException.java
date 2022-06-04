package com.example.demo.error;

public class CourseNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CourseNotFoundException(String s) {
		super(s);
	}
}
