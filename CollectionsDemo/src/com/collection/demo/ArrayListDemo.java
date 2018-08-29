package com.collection.demo;

import java.util.ArrayList;

public class ArrayListDemo 
{
	public static void main(String[] args) 
	{
		Emp e1 = new Emp(111, "Amit");
		Emp e2 = new Emp(222, "Sumit");
		Emp e3 = new Emp(333, "Ravi");
		
		ArrayList<Emp> al = new ArrayList<Emp>();
		al.add(e1);		//Adding 1st object to ArrayList
		al.add(null);	//Adding 'null' as 2nd object
		al.add(e2);		
		al.add(e3);
		
		System.out.println(al);	//prints all objects of ArrayList
		
		al.add(2, e3);	//Adding e3 again on index 2 
		
		System.out.println(al);
		
		al.remove(2); //removes 2nd index object
		
		System.out.println(al);
		
		ArrayList<Emp> al2 = new ArrayList<Emp>();
		
		al2.addAll(al);	//Adding every object of ArrayList al
		
		al2.add(e1);
		
		System.out.println(al2);
	}

}
