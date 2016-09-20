package com.DataStructAndAlgorth.myhashmap;

public class Employee {
	private String name;
	private double salary;
	private int seniority;
	public boolean eaqual(Object rhs){
		return rhs instanceof Employee && name.equals( ((Employee)rhs).name);
	}
	
	public int hashcode(){
		return name.hashCode();
	}
	
}
