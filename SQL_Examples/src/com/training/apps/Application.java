package com.training.apps;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;
import com.training.utils.SqlConnection;
//import java.sql.*;

public class Application {

	public static void main(String[] args) {

		// System.out.println(SqlConnection.getOracleConnection());
		
		Customer cust = new Customer(102, "Dhawal", "dsin@sapient.com", 231197);
		CustomerDAO dao = new CustomerDAO();
		int rowAdded = dao.add(cust);
		
	}

}
