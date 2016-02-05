package com.training.apps;

import com.training.utils.SqlConnection;
import java.sql.*;

public class Application {

	public static void main(String[] args) {

		System.out.println(SqlConnection.getOracleConnection());
	}

}
