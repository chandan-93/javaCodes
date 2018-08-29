package com.collection.demo;

public class Emp 
{
	int eId;
	String eName;
	
	public Emp()
	{
		
	}

	public Emp(int eId, String eName)
	{
		this.eId = eId;
		this.eName = eName;
	}

	public String toString() 
	{
		return "Emp [eId=" + eId + ", eName=" + eName + "]";
	}
	
	
}
