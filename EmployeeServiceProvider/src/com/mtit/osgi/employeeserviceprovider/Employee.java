package com.mtit.osgi.employeeserviceprovider;

public class Employee {
	 private String eName;
     private String edesination; 
	 private int eAge;
	 private double eSalary;
	 
	public Employee(String eName, String edesination, int eAge, double eSalary) {
		super();
		this.eName = eName;
		this.edesination = edesination;
		this.eAge = eAge;
		this.eSalary = eSalary;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEdesination() {
		return edesination;
	}

	public void setEdesination(String edesination) {
		this.edesination = edesination;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

	public double geteSalary() {
		return eSalary;
	}

	public void seteSalary(Double eSalary) {
		this.eSalary = eSalary;
	}
	
	
}
