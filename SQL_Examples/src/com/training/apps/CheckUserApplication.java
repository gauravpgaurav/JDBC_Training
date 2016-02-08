package com.training.apps;

import com.training.entity.User;
import com.training.utils.ValidateUser;

import java.util.*;

public class CheckUserApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter UserName :\t");
		String userName = sc.next();
		System.out.print("Enter Password :\t");
		String passWord = sc.next();
		sc.close();

		User userIns = new User(userName, passWord);

		ValidateUser validateIns = new ValidateUser();
		System.out.println("Logged In :\t\t" + validateIns.validate(userIns));

	}
}
