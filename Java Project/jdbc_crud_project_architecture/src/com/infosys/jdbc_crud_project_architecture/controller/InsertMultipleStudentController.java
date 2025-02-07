package com.infosys.jdbc_crud_project_architecture.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.infosys.jdbc_crud_project_architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_architecture.dto.Student;

public class InsertMultipleStudentController {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		
		Student student1 = 
				new Student(888, "tajdar", "raza@gmail.com", 765372, LocalDate.parse("2002-09-13"));
		Student student2 = 
				new Student(222, "mohsin", "pasha@gmail.com", 5432165, LocalDate.parse("2002-09-13"));
		Student student3 = 
				new Student(1414, "saurav", "saurav@gmail.com", 86876, LocalDate.parse("2002-09-13"));
	
		List<Student> students = Arrays.asList(student1,student2,student3);
		
		dao.saveMultipleStudentDao(students);
	
	}
}
