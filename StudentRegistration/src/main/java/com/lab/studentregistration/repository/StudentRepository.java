package com.lab.studentregistration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.studentregistration.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByNameContainsAndDepartmentContainsAllIgnoreCase(String name, String department);
}