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
        int eCount = 0;
		
		for (Employee emp : employees) {
			
			if (emp.geteName().toLowerCase().equals(eName.toLowerCase())) {
				return eCount;
			}
			eCount++;
		}
		
		eCount = -1;
		return eCount;
	}

	@Override
	public String displayBookDetail(int index) {
		return  "   Employee ID : " + index + 1 + "\n"+
				"   Employee Name : " + employees.get(index).geteName() + "\n"+
				"   Employee Desination : " + employees.get(index).getEdesination() + "\n"+
				"   Employee Age : "  + employees.get(index).geteAge() + "\n"+
				"   Employee Salary : "+ employees.get(index).geteSalary() + "\n" ;
	}

	@Override
	public String displayAllEmployees() {
        String employeeDetails = "";
		
		if (employees.size() > 0) {
			int bCount = 1;
			for (Employee e : employees) {
				employeeDetails += bCount + "    " + e.geteName() + "\t" + e.getEdesination() + "\t\t" + "Rs."
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
	
	public String getEmployeeDesignation(int index) {
		return employees.get(index).getEdesination();
	}
	
	public double getEmployeeSalary(int index) {
		return employees.get(index).geteSalary();
	}
	
	public int getEmployeAge(int index) {
		return employees.get(index).geteAge();
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
