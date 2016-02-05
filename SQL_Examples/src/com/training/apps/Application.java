package com.training.apps;

import java.util.*;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;

public class Application {

	public static void main(String[] args) {

		
		Customer cust = new Customer(112, "Das", "das@sapient.com", 23232237);
		CustomerDAO dao = new CustomerDAO();
		//System.out.println("Added "+dao.add(cust)+" Row !");
		System.out.println(dao.find(112));
		System.out.println();
		List<Customer> custList = dao.findAll();
		for (Customer i : custList) 
			System.out.println(i);
		
	}

}
