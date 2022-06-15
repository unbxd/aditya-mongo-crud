package com.example.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ServiceStudent {
	
	@Autowired
	RepositoryStudent studentRepository;
	public Student createStudent(Student student) {
		return studentRepository.save(student);		
	}
	
	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();		
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);		
	}
	
	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "the student has been deleted";
	}

}
