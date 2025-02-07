package com.infosys.jdbc_crud_project_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_crud_project_architecture.connection.StudentConnection;
import com.infosys.jdbc_crud_project_architecture.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	final String INSERT_STUDENT_QUERY = "insert into student(id,name,email,phone,dob) values(?,?,?,?,?)";

	final String GET_STUDENT_BY_ID_QUERY = "SELECT * FROM STUDENT WHERE id=?";

	final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM STUDENT WHERE id=?";

	final String SELECT_ALL_STUDENT_BY_ID_QUERY = "SELECT * FROM STUDENT";

	final String UPDATE_STUDENT_PHONE_BY_ID_QUERY = "UPDATE STUDENT SET phone=? WHERE id=?";

	public Student saveStudentDao(Student student) {
		System.out.println("dao save method started");
		try {

			PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT_QUERY);

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.setObject(5, student.getDob());

			int a = ps.executeUpdate();

			if (a != 0) {
				System.out.println("data inserted");
				return student;
			} else {
				System.out.println("data not inserted");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Student getStudentByIdDao(int studentId) {
		try {

			PreparedStatement ps = connection.prepareStatement(GET_STUDENT_BY_ID_QUERY);

			ps.setInt(1, studentId);

			ResultSet set = ps.executeQuery();

			if (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setPhone(phone);
				student.setDob(dob);

				return student;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteStudentByIdDao(int studentId) {

		try {

			PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);

			ps.setInt(1, studentId);

			int a = ps.executeUpdate();

			if (a != 0) {

				return true;
			} else {

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> getAllStudentDao() {
		try {

			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STUDENT_BY_ID_QUERY);

			ResultSet set = ps.executeQuery();

			List<Student> students = new ArrayList<Student>();

			while (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setPhone(phone);
				student.setDob(dob);

				students.add(student);
			}

			return students;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateStudentPhoneByIdDao(int studentId,long phone) {

		try {

			PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT_PHONE_BY_ID_QUERY);

			ps.setLong(1, phone);
			ps.setInt(2, studentId);

			int a = ps.executeUpdate();

			if (a != 0) {

				return true;
			} else {

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Student> saveMultipleStudentDao(List<Student> students) {
		
		System.out.println("dao save method started");
		try {

			PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT_QUERY);

			for (Student student : students) {
				
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getEmail());
				ps.setLong(4, student.getPhone());
				ps.setObject(5, student.getDob());
				ps.addBatch();	
				
			}
			int a[] = ps.executeBatch();

			if (a.length!=0) {
				System.out.println("data inserted");
				return students;
			} else {
				System.out.println("data not inserted");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
