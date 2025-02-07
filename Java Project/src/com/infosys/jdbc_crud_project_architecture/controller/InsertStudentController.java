package com.infosys.jdbc_crud_project_architecture.controller;

import java.time.LocalDate;

import com.infosys.jdbc_crud_project_architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_architecture.dto.Student;
import com.infosys.jdbc_crud_project_architecture.service.StudentService;

public class InsertStudentController {

	public static void main(String[] args) {
		System.out.println("main method started");
		StudentService service = new StudentService();
		
		
		Student student = 
		new Student(777, "sohit", "sohit@gmail.com", 78687689, LocalDate.parse("2002-09-13"));
	    
		service.saveStudentService(student);
		System.out.println("main method ended");
	}
}
