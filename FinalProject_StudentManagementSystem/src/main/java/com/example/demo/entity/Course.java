package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Course {
@Id
@GeneratedValue(generator="seq", strategy=GenerationType.AUTO)
@SequenceGenerator(name="seq", initialValue=1000)
private Long cid;
private String coursename;
private Double coursefees;


@OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
@JoinColumn(name="cid")
private List<Student> student;


public Course() {
	super();
}


public Course(Long cid, String coursename, Double coursefees, List<Student> student) {
	super();
	this.cid = cid;
	this.coursename = coursename;
	this.coursefees = coursefees;
	this.student = student;
}


public Long getCid() {
	return cid;
}


public void setCid(Long cid) {
	this.cid = cid;
}


public String getCoursename() {
	return coursename;
}


public void setCoursename(String coursename) {
	this.coursename = coursename;
}


public Double getCoursefees() {
	return coursefees;
}


public void setCoursefees(Double coursefees) {
	this.coursefees = coursefees;
}


public List<Student> getStudent() {
	return student;
}


public void setStudent(List<Student> student) {
	this.student = student;
}


@Override
public String toString() {
	return "Course [cid=" + cid + ", coursename=" + coursename + ", coursefees=" + coursefees + ", student=" + student
			+ "]";
}


}
