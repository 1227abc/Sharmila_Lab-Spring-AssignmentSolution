package com.lab.studentregistration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.studentregistration.entity.Student;
import com.lab.studentregistration.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);

	}

	@Override
	public List<Student> searchBy(String name, String dept) {
		List<Student> students = studentRepository.findByNameContainsAndDepartmentContainsAllIgnoreCase(name, dept);
		return students;
	}

}