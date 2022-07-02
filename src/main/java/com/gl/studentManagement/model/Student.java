package com.gl.studentManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This is the Entity class
@Entity
@Table(name = "student")
public class Student {

	// Map java fields to database table columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private int studentId;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private String department;

	@Column(name = "country")
	private String country;

	// Default constructor
	public Student() {

	}

	public Student(int studentId, String name, String department, String country) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.department = department;
		this.country = country;
	}

	// Getters & Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
