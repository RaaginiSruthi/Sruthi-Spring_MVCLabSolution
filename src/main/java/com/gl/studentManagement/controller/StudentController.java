package com.gl.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.studentManagement.model.Student;
import com.gl.studentManagement.service.StudentDAO;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Inject DAO into this controller
	@Autowired
	private StudentDAO studentDAO;

	@GetMapping("/list")
	public String listStudents(Model theModel) {

		// get students from DAO
		List<Student> theStudents = studentDAO.getStudents();

		// add the students to our spring mvc model
		theModel.addAttribute("students", theStudents);

		return "list-students";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {

		// save the student
		studentDAO.save(theStudent);
		return "redirect:/student/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get student from our service/DAO
		Student theStudent = studentDAO.findById(theId);

		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		// send over to our form
		return "student-form";

	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		// delete the student
		studentDAO.deleteById(theId);
		return "redirect:/student/list";
	}

}
