package com.training.utils;

import java.sql.*;

import com.training.entity.User;

public class ValidateUser {

	private Connection con;
	private ResultSet rs;

	public ValidateUser() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public ValidateUser(Connection con) {
		super();
		this.con = con;
	}

	private void getResultSet() {

		String sql = "select * from VERIFYUSER";

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public Boolean validate(User userIns) {
		getResultSet();

		Boolean result = false;
		String userName, passWord;

		try {
			while (rs.next()) {

				userName = rs.getString("userName");
				if (userName.equals(userIns.getUserName())) {
					passWord = rs.getString("passWord");
					if (passWord.equals(userIns.getPassWord())) {
						result = true;
						break;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
