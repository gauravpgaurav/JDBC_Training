package com.training.daos;

import java.util.List;
import java.sql.*;

import com.training.entity.Customer;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;

public class CustomerDAO implements DAO<Customer> {

	private Connection con;

	public CustomerDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Customer t) {

		String sql = "insert into customer values(?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCustomerId());
			pstmt.setString(2, t.getCustomerName());
			pstmt.setString(3, t.getEmail_Id());
			pstmt.setLong(4, t.getHandPhone());
			rowAdded = pstmt.executeUpdate();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
