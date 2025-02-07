package com.jspider.jdbc_simple_crud_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class UpdateEmployeeController {
public static void main(String[] args) {
	
	//Step-1 Load / Register
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	//Step-2 Creaate Connection
		
		String url="jdbc:mysql://localhost:3306/jdbc-m12";
		String userName="root";
		String pssWord="root";
		Connection connection=DriverManager.getConnection(url, userName, pssWord);
		
	// Step-3 Create Statement
		
		Statement statement=connection.createStatement();
		
	// Step-4 Execute Query
		
		String UpdateEmployeeQuery="update employee set name='Mohan Mishra' where id=1226";
		int a=statement.executeUpdate(UpdateEmployeeQuery);
		 if (a != 0) {
             System.out.println("Data Updated .");
         } else {
             System.out.println("Something went wrong.");
         }
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
