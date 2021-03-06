package com.training.apps;

import java.util.*;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;

public class Application {

	public static void main(String[] args) {

		int option = 0, suboption, customerId;
		String customerName, customerEmail;
		long handPhone;
		Scanner sc = new Scanner(System.in);

		Customer cust = new Customer(112, "Das", "das@sapient.com", 23232237);
		CustomerDAO dao = new CustomerDAO("customer");

		System.out.println();

		while (option != 6) {
			System.out.println("\n ******** Customer Database App ******** ");
			System.out.println("\t 1. Add Customer ");
			System.out.println("\t 2. View A Customer By Id");
			System.out.println("\t 3. View All Customers");
			System.out.println("\t 4. Update Customer Detials ");
			System.out.println("\t 5. Delete A Customer ");
			System.out.println("\t 6. Exit ");
			System.out.print("\n Enter Key : \t");
			option = sc.nextInt();

			switch (option) {

			case 1:
				System.out.print("\n\nEnter Customer ID :  \t");
				customerId = sc.nextInt();
				System.out.print("Enter Customer Name :  \t");
				customerName = sc.next();
				System.out.print("Enter Customer Email :  \t");
				customerEmail = sc.next();
				System.out.print("Enter Handphone Number :  \t");
				handPhone = sc.nextLong();
				cust = new Customer(customerId, customerName, customerEmail, handPhone);
				System.out.println("\nAdded " + dao.add(cust) + " Row !");
				break;

			case 2:
				System.out.print("\n\nEnter Customer ID :  \t");
				customerId = sc.nextInt();
				System.out.println(dao.find(customerId));
				break;

			case 3:
				List<Customer> custList = dao.findAll();
				for (Customer i : custList)
					System.out.println(i);
				break;

			case 4:
				System.out.print("\n\nEnter Customer ID :  \t");
				customerId = sc.nextInt();
				System.out.println("\n\t 1. Update Email ");
				System.out.println("\t 2. Update Handphone Number");
				System.out.print("\n Enter Key : \t");
				suboption = sc.nextInt();
				switch (suboption) {

				case 1:
					System.out.print("Enter New Customer Email :  \t");
					customerEmail = sc.next();
					System.out.println("\nUpdated " + dao.update(customerId, customerEmail) + " Email !");
					break;
				case 2:
					System.out.print("Enter New Handphone Number :  \t");
					handPhone = sc.nextLong();
					System.out.println("\nUpdated " + dao.update(customerId, handPhone) + " Handphone Number !");
					break;
				default:
					System.out.println("\n\t ERROR : Incorrect Input ! ");
					continue;
				}
				break;

			case 5:
				System.out.print("\n\nEnter Customer ID :  \t");
				customerId = sc.nextInt();
				System.out.println("\nDeleted " + dao.delete(customerId) + " Row !");
				break;

			case 6:
				System.out.println("\n\t Exited ! ");
				break;
			default:
				System.out.println("\n\t ERROR : Incorrect Input ! ");
				continue;

			}

		}

		sc.close();
	}

}
