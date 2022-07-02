package com.gl.studentManagement.service;

import java.util.List;

import com.gl.studentManagement.model.Student;

public interface StudentDAO {

	public List<Student> getStudents();
	public Student findById(int id);
	public void save(Student theStudent);
	public void deleteById(int id);

}
