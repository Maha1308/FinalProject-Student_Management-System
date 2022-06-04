package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Student {
@Id
@GeneratedValue
private Long sid;
@NotNull(message="Student name cannot be null")
@NotBlank(message="Student name cannot be blank")
private String sname;
@Range(min=20, message="Student age cannot be less than 20 years")
private Integer sage;
@NotBlank(message="Place should not be blank")
private String splace;
@Column(unique=true)
@Email
private String semail;
@Column(length=10)
private String smobile;

public Student() {
	super();
}

public Student(Long sid,
		@NotNull(message = "Student name cannot be null") @NotBlank(message = "Student name cannot be blank") String sname,
		@Range(min = 20, message = "Student age cannot be less than 20 years") Integer sage,
		@NotBlank(message = "Place should not be blank") String splace, @Email String semail, String smobile) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.sage = sage;
	this.splace = splace;
	this.semail = semail;
	this.smobile = smobile;
}

public Long getSid() {
	return sid;
}

public void setSid(Long sid) {
	this.sid = sid;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}

public Integer getSage() {
	return sage;
}

public void setSage(Integer sage) {
	this.sage = sage;
}

public String getSplace() {
	return splace;
}

public void setSplace(String splace) {
	this.splace = splace;
}

public String getSemail() {
	return semail;
}

public void setSemail(String semail) {
	this.semail = semail;
}

public String getSmobile() {
	return smobile;
}

public void setSmobile(String smobile) {
	this.smobile = smobile;
}

@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", splace=" + splace + ", semail=" + semail
			+ ", smobile=" + smobile + "]";
}

}
