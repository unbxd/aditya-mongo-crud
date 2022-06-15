package com.example.CRUD;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

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

@RestController
public class ControllerStudent {
	
	Logger logger = LoggerFactory.getLogger(ControllerStudent.class);
	@Autowired 
	ServiceStudent studentService;
	
		@PostMapping("/create")
		public Student createStudent(@RequestBody Student student) {
			logger.info("request received for creation :- "+student);
			try {
			return studentService.createStudent(student);
			}catch(Exception e) {
				StringWriter sw = new StringWriter();
	            e.printStackTrace(new PrintWriter(sw));
	            String exceptionAsString = sw.toString();
				logger.error(exceptionAsString);
				return null;
			}
			
		}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		logger.info("request received for extraction with id :- "+id);
		try {
		return studentService.getStudentById(id);
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
			logger.error(exceptionAsString);
			return null;
		}
		
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		logger.info("request received for all data :- "+studentService.getAllStudents());
		try {
		return studentService.getAllStudents();
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
			logger.error(exceptionAsString);
			return null;
		}
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		logger.info("request received for creation :- "+student);
		try {
		return studentService.updateStudent(student);
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
			logger.error(exceptionAsString);
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		logger.info("request received for deletion id :- "+id);
		try {
		return studentService.deleteStudent(id);
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
			logger.error(exceptionAsString);
			return null;
		}
	}

}
