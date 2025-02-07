package com.jspider.jdbc_simple_crud_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Statement;

public class DeleteEmployeeController {
public static void main(String[] args) {
	
	try {
		//step-1 Load/Register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 Create Connection
		String url="jdbc:mysql://localhost:3306/jdbc-m12";
		String userName="root";
		String passWord="root";
		
		Connection connection=DriverManager.getConnection(url, userName, passWord);
		//step - 3 create statement
		Statement statement=connection.createStatement();
		
		
		//Step - 4 Execute Query
		String deleteEmployeeByIdQuery = "delete from employee where id=1226";
		int a=statement.executeUpdate(deleteEmployeeByIdQuery);
		
		 if (a != 0) {
             System.out.println("Data Deleted.");
         } else {
             System.out.println("Something went wrong.");
         }
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}
}


// tASK INSERT UPDATE DELETE LLL