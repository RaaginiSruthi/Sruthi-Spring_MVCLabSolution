package com.gl.studentManagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.studentManagement.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Student> getStudents() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the query
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);

		// execute query to get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Transactional
	@Override
	public Student findById(int id) {
		
		Student student = new Student();

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find record with Id from the database
		student = currentSession.get(Student.class, id);

		return student;
	}

	@Transactional
	@Override
	public void save(Student theStudent) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save transaction
		currentSession.saveOrUpdate(theStudent);
	}

	@Transactional
	@Override
	public void deleteById(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get transaction
		Student student = currentSession.get(Student.class, id);

		// delete record
		currentSession.delete(student);
	}
}
