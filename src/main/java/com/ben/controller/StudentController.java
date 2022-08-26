package com.ben.controller;

import com.ben.model.Student;
import com.ben.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController// Useful to create the RESTful webservices.
public class StudentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// Save student entity in the h2 database.
	@PostMapping(value= "/student/save")
	public int save(final @RequestBody @Valid Student student) {
		log.info("Saving student details in the database.");
		service.save(student);
		return student.getId();
	}

	// Get all students from the h2 database.
	@GetMapping(value= "/student/getall", produces= "application/vnd.jcg.api.v1+json")
	public List<Student> getAll() {
		log.info("Getting student details from the database.");
		return service.getAll();
	}

	@GetMapping("/hello")
	public String hello() {
		String message = "Hello AWS! BEN";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			log.info("Exception.");
			e.printStackTrace();
		}
		return message;
	}
}
