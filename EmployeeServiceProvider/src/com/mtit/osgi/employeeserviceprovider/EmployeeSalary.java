package com.mtit.osgi.employeeserviceprovider;

import java.util.ArrayList;
import java.util.List;


public class EmployeeSalary extends Employee{
	int otHrs;
    double otRate;
    double netSalary;
    
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
	
	private static List<EmployeeSalary> empSalaryReceipt = new ArrayList<>();
	
    public static boolean addSlary(EmployeeSalary e1) {

		if (e1 != null) {
			empSalaryReceipt.add(e1);
		} else {
		    return false;
		}
		return true;
	}
    
    public static String displayAllEmployeeSalaryDetails() {
        String employeeSalaryDetails = "";
		
		if (empSalaryReceipt.size() > 0) {
			int bCount = 1;
			for (EmployeeSalary eSalary : empSalaryReceipt) {
				employeeSalaryDetails += bCount + "    " + eSalary.geteName() + "\t" + eSalary.getEdesination() + "\t" + "Rs."
						+ eSalary.geteSalary() +"\t"+ eSalary.getOtHrs()+ "\t" + eSalary.getOtRate() +"\t"+ eSalary.getNetSalary()+ "\n";
				bCount++;
			}
		} else {
			employeeSalaryDetails = "Not registered Employee Salary Details!";
		}
		return employeeSalaryDetails;
	}
	
	 
    
}
