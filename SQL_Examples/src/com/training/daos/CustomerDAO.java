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

	@Override
	public int add(Customer t) {
		// TODO Auto-generated method stub
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
