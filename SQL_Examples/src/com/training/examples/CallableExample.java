package com.training.examples;
import java.sql.*;

public class CallableExample {

	public static void main(String[] args){
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:system/db@localhost:1521:XE";
			
			Connection con = DriverManager.getConnection(url);
			
			CallableStatement stmt = con.prepareCall("call updatePhoneNumber (?,?)");
			
			stmt.setInt(1, 102);
			stmt.setLong(2, 11111L);
		
			stmt.execute();
			int count = stmt.getUpdateCount();
			System.out.println(" \t But Number of Updated Rows = "+count);
			// If true resultSet was returned
			// If false nothing was returned. Hence false returned
			System.out.println("Thanks for updating Phone Number");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
