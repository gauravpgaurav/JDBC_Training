package com.training.daos;

import java.util.*;
import java.sql.*;

import com.training.entity.Customer;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;

public class CustomerDAO implements DAO<Customer> {

	private Connection con;
	private String tableName;

	public CustomerDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public CustomerDAO(String tableName) {
		super();
		this.tableName = tableName;
		con = SqlConnection.getOracleConnection();
	}

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Customer t) {

		String sql = "insert into " + tableName + " values(?,?,?,?)";
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

			System.out.println(e.getMessage());
		}
		return rowAdded;
	}

	@Override
	public Customer find(int key) {

		String sql = "select * from " + tableName + " where customerid =?";
		Customer resultCustomer = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				resultCustomer = getCustomer(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultCustomer;
	}

	private Customer getCustomer(ResultSet rs) {

		Customer cust = null;
		try {

			cust = new Customer(rs.getInt("customerid"), rs.getString("customername"), rs.getString("customeremail"),
					rs.getLong("handphone"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cust;
	}

	@Override
	public List<Customer> findAll() {

		String sql = "select * from " + tableName;
		ArrayList<Customer> custList = new ArrayList<Customer>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				custList.add(getCustomer(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return custList;
	}

	@Override
	public int update(int key, String email) {

		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate(
					"update " + tableName + " set " + "customeremail='" + email + "' where customerid='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int update(int key, long handPhone) {
		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate(
					"update " + tableName + " set " + "handphone='" + handPhone + "' where customerid='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from " + tableName + " where customerid = " + key;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			rowDeleted = stmt.executeUpdate(sql);
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;
	}

}
