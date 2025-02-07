package com.infosys.jdbc_crud_project_architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {

	public static Connection getStudentConnection() {
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m12","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
