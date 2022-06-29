package com.example.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_student {
	
	@Autowired
	repository_student studentRepository;
	public student createStudent(student student) {
		return studentRepository.save(student);		
	}
	
	public student getStudentById(String id) {
		return studentRepository.findById(id).get();		
	}
	
	public List<student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public student updateStudent(student student) {
		return studentRepository.save(student);		
	}
	
	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "the student has been deleted";
	}

}
