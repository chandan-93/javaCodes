package com.foodplaza.dao;

import java.util.Scanner;

import com.foodplaza.pojo.Customer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		FoodPlazaDao fpd = new FoodPlazaDao();
		Scanner sc = new Scanner(System.in);
		
		String custEmail;
		System.out.println("Enter email: ");
		custEmail = sc.next();
		
		c = fpd.searchByEmail(custEmail);
		System.out.println(c);
	}

}
