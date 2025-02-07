package com.jspider.jdbc_simple_crud_operation;

/**
 * Here, are the important key points before 
 * connecting to the database with a Java application. You must add the jar file mysql-connector.
 * 1. Right-click the project.
 * 2. Go to properties and locate mysql-connector in your system or add the path.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeController {
    public static void main(String[] args) {
    	Connection connection=null;
        try {
            // Step 1: Load / register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m12", "root", "root");

            // Step 3: Create statement
            Statement statement = connection.createStatement();

            // Step 4: Execute query
            String insertEmployeeQuery = "INSERT INTO employee (id, name, email, phone, salary, doj) VALUES (1225, 'Reena Thakur', 'thakur123@gmail.com', 9581873683, 153000, '2024-01-22')";
            int a = statement.executeUpdate(insertEmployeeQuery);

            if (a != 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Something went wrong.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
          
        }
        finally {
        	//step-5 close connection
        	try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
        }
    }
}
