package com.lab.studentregistration.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab.studentregistration.entity.Student;
import com.lab.studentregistration.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> students = studentService.findAll();

		theModel.addAttribute("Students", students);

		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student student = new Student();

		theModel.addAttribute("Student", student);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		Student student = studentService.findById(theId);

		theModel.addAttribute("Student", student);

		return "Student-form";
	}

	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String dept, @RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(dept);
			student.setCountry(country);
		} else
			student = new Student(name, dept, country);

		studentService.save(student);

		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		studentService.deleteById(theId);

		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}
}