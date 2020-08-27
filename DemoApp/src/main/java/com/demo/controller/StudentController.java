package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.services.StudentService;

@RestController
public class StudentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	StudentService service;

	@PostMapping(value= "/student/save")
	public Student save(final @RequestBody Student student) {
		log.info("Saving student details in the database.");
		service.save(student);
		return service.findStudentById(student.getId());
	}

	@GetMapping(value= "/student/getall", produces= "application/json")
	public List<Student> getAll() {
		log.info("Getting student details from the database.");
		return service.getAll();
	}
	
    @DeleteMapping("/student/{id}")
    public Student deleteEmployeeById(@PathVariable("id") Integer id) {
        service.deleteStudentById(id);
        return null;
    }
    
    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        service.updateStudentById(student,id);
		return service.findStudentById(id);
    }
}
