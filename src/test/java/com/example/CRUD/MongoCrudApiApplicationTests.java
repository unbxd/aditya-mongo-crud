package com.example.CRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MongoCrudApiApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private RepositoryStudent studentRepositoy;

	@Test
	void find_by_id() {
		Student student = studentRepositoy.findById("627a04e1bfd46a19394a8ae6").get();
		System.out.println(student.getName());
		assertEquals(student.getName(), "Hrithik");
		assertEquals(student.getEmail(), "Hrithik09@gmail.com");
	}
	
	@Test
	void find() {
		long s = studentRepositoy.count();
		assertEquals(3, s);
		
	}
	
	@Test
	void fields() {
		List<Student> student = studentRepositoy.findAll();
		System.out.println(student.get(0).getSubject());
		
	}

	


}
