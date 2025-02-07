package com.infosys.jdbc_crud_project_architecture.controller;

import java.util.List;

import com.infosys.jdbc_crud_project_architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_architecture.dto.Student;

public class DisplayAllStudentController {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		List<Student> students=dao.getAllStudentDao();
		
		
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
