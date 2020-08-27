package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public void save(final Student student) {
		repository.save(student);
	}

	public List<Student> getAll() {
		final List<Student> students = new ArrayList<>();
		repository.findAll().forEach(student -> students.add(student));
		return students;
	}
	
	public void deleteStudentById(Integer id) 
    {
        Optional<Student> student = repository.findById(id);
         
        if(student.isPresent()) 
        {
            repository.deleteById(id);
        } 
    }

	public void updateStudentById(Student student, Integer id) {
    	Optional<Student> stu = repository.findById(id);
    	 if(stu.isPresent()) 
         {    	    	
    	    	repository.save(student);         
         } 
	} 
	
	public Student findStudentById(Integer id) {
    	Optional<Student> stu = repository.findById(id);
    	 if(stu.isPresent()) 
         {    	    	
    		 return stu.get();
         } else{
        	 return null;
         }
	} 
}
