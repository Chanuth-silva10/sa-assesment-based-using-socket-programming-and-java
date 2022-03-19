package com.mtit.osgi.employeeserviceprovider;

import java.util.List;


public interface EmployeeService {

	    
	 public int searchEmployee(String name);
	 	
	 	
	 public String displayBookDetail(int index);
	 	
	 	
	 public String displayAllEmployees();
	 	
	 	
	 public double getBookPrice(int index);
	 	
	 	
	 public boolean addBookItem(Employee p);
	 	
	 	
	 public boolean deleteBookItem(int index);
	 	
	 	
	 public int getEmployeeCount();

	 	
	 public String getEmployeeName(int index);
	 	
	 	
	 public boolean editEmployeeName(int index, String ename);
	 	
	 	
	 public boolean editEmployeeAge(int index, int qty);
	 	
	 	
	 public boolean editEmployeePrice(int index, double price);
	 			
		
	 public boolean editEmployeeDesination(int index, String desc); 
}
