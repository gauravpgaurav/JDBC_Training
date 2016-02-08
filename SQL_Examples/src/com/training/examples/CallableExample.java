package com.training.examples;

import java.sql.*;

public class CallableExample {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/gpant";

			Connection con = DriverManager.getConnection(url,"root","root");

			CallableStatement stmt = con.prepareCall("Call updatePhoneNumber (?,?)");

			stmt.setInt(1, 875);
			stmt.setLong(2, 11111L);
			System.out.println(stmt.execute());
			// If true resultSet was returned
			// If false nothing was returned. Hence false returned
			System.out.println("Thanks for updating Phone Number");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}