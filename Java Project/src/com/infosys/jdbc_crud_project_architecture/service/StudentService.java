package com.infosys.jdbc_crud_project_architecture.service;

import com.infosys.jdbc_crud_project_architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_architecture.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();
	
	public Student saveStudentService(Student student) {
		System.out.println("service save method started");
		int year=student.getDob().getYear();
		
		if(year>2000) {
			return dao.saveStudentDao(student);
		}else {
			System.out.println("student dob year is not eligible it should be more than 2000");
			return null;
		}
	}
}

