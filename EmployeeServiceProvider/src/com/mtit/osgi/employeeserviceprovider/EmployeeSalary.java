package com.mtit.osgi.employeeserviceprovider;

import java.util.ArrayList;
import java.util.List;


public class EmployeeSalary extends Employee{
	public int otHrs;
    public double otRate;
    public double netSalary;
    
	public static List<EmployeeSalary> empSalaryReceipt = new ArrayList<>();

    
    public EmployeeSalary(String eName, String edesination, int eAge, double eSalary,int otHrs, double otRate, double netSalary ) {
		super(eName, edesination, eAge, eSalary);
		
	}

	public int getOtHrs() {
		return otHrs;
	}

	public void setOtHrs(int otHrs) {
		this.otHrs = otHrs;
	}

	public double getOtRate() {
		return otRate;
	}

	public void setOtRate(double otRate) {
		this.otRate = otRate;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

    
   
	
	 
    
}
