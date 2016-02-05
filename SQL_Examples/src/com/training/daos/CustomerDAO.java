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

			System.out.println("Row Added !");
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer find(int key) {

		String sql = "select * from customer where customerid =?";
		Customer resultCustomer = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				int customerId = rs.getInt("customerid");
				String cutomerName = rs.getString("customername"); 
				String email_Id = rs.getString("customeremail");
				Long handPhone = rs.getLong("handphone");
				resultCustomer = new Customer(customerId, cutomerName, email_Id, handPhone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultCustomer;
	}

	@Override
	public List<Customer> findAll() {

		String sql = "select * from customer";

		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("customerid") + "\t" + rs.getString("customername") + "\t"
						+ rs.getString("customeremail") + "\t" + rs.getLong("handphone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
