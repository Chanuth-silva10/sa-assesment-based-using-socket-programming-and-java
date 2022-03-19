package com.mtit.osgi.employeeserviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.employeeserviceprovider.Employee;


public class EmployeeServiceImpl implements EmployeeService{

	
	private List<Employee> employees = new ArrayList<Employee>() {
		{
			add(new Employee("Chanuth","StockKeeper", 21, 15000));
			add(new Employee("Imasha","Cashier", 21, 25000));
			add(new Employee("Hasitha","driver", 18, 15000));
			add(new Employee("OKG","StockKeeper", 11, 15000));
			
		}
	};

	@Override
	public int searchEmployee(String eName) {
        int bCount = 0;
		
		for (Employee emp : employees) {
			
			if (emp.geteName().toLowerCase().equals(eName.toLowerCase())) {
				return bCount;
			}
			bCount++;
		}
		
		bCount = -1;
		return bCount;
	}

	@Override
	public String displayBookDetail(int index) {
		return "Employee Name : " + employees.get(index).geteName() + 
				", Employee Desination : " + employees.get(index).getEdesination() +
				",Employee Age : "  + employees.get(index).geteAge() + 
				"Employee Salary : "+ employees.get(index).geteSalary() +
				 ".........." ;
	}

	@Override
	public String displayAllEmployees() {
        String employeeDetails = "";
		
		if (employees.size() > 0) {
			int bCount = 1;
			for (Employee e : employees) {
				employeeDetails += bCount + "    " + e.geteName() + "\t" + e.getEdesination() + "\t" + "Rs."
						+ e.geteSalary() +"\t"+ e.geteAge() +  "\n";
				bCount++;
			}
		} else {
			employeeDetails = "Not registered Employee ";
		}
		return employeeDetails;
	}
    
	@Override
	public double getBookPrice(int index) {
		return employees.get(index).geteSalary();
		
	}

	@Override
	public boolean addBookItem(Employee employee) {
		employees.add(employee);
		return true;
	}

	@Override
	public boolean deleteBookItem(int i) {
		employees.remove(i);
		return true;
	}

	@Override
	public int getEmployeeCount() {
		return employees.size();
	}

	@Override
	public String getEmployeeName(int index) {
		return employees.get(index).geteName();
	}

	@Override
	public boolean editEmployeeName(int index, String name) {
		employees.get(index).seteName(name);
		return true;
	}

	@Override
	public boolean editEmployeeAge(int index, int age) {
		employees.get(index).seteAge(age);;
		return true;
	}

	
	public boolean editEmployeeDesination(int index, String desination) {
		employees.get(index).setEdesination(desination);
		return true;
	}


	@Override
	public boolean editEmployeePrice(int index, double salary) {
		employees.get(index).seteSalary(salary);
		return true;
	}

	
	

}
