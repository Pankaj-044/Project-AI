package com.infosys.jdbc_crud_project_architecture.controller;

import com.infosys.jdbc_crud_project_architecture.dao.StudentDao;
import com.infosys.jdbc_crud_project_architecture.dto.Student;

public class GetStudentByIdController {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		Student student=dao.getStudentByIdDao(3456);
		
		if(student!=null) {
			System.out.println(student);
		}else {
			System.out.println("given id is not found or check with your code");
		}
	}
}
