package com.example.CRUD;

import org.springframework.data.mongodb.core.mapping.Field;

public class department {
	
	@Field(name="department_name")
	private String departmentName;
	private String location;
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}

