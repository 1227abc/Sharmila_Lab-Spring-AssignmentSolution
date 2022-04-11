package com.lab.studentregistration.service;

import java.util.List;

import com.lab.studentregistration.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student student);

	public void deleteById(int theId);

	public List<Student> searchBy(String name, String author);

}
