package com.example.demo.error;

public class StudentNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String s) {
		super(s);
	}
}
