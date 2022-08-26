package com.ben.service;

import com.ben.model.Student;
import com.ben.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	// Save student entity in the h2 database.
	public void save(final Student student) {
		repository.save(student);
	}

	// Get all students from the h2 database.
	public List<Student> getAll() {
		final List<Student> students = new ArrayList<>();
		repository.findAll().forEach(student -> students.add(student));
		return students;
	}
}
