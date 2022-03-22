package com.mtit.osgi.employeeserviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.employeeserviceprovider.Employee;


public class EmployeeServiceImpl implements EmployeeService{

	
	private List<Employee> employees = new ArrayList<Employee>() {
		{
			add(new Employee("Chanuth","StockKeeper", 21, 15000));
			add(new Employee("Imasha ","Cashier    ", 21, 25000));
			add(new Employee("Hasitha","driver     ", 18, 15000));
			add(new Employee("OKG    ","StockKeeper", 11, 15000));
			
		}
	};
	
	public static  List<EmployeeSalary> empSalaryReceipt = new ArrayList<>();

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
	public String displayEmployeeDetail(int index) {
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
	public boolean addEmployee(Employee employee) {
		employees.add(employee);
		return true;
	}


	@Override
	public boolean deleteEmployee(int i) {
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

	@Override
	public boolean addSlary(String eName, String eDesignation, int age, double eBasicSalary, int otHrs, double otRate,
			double eNetSalary) {
		
		EmployeeSalary e1 = new EmployeeSalary(eName, eDesignation, age, eBasicSalary, otHrs, otRate, eNetSalary);
		
		if (e1 != null) {
			empSalaryReceipt.add(e1);
		} else {
		    return false;
		}
		
		return true;
		
	}
	
	 public  String displayAllEmployeeSalaryDetails() {
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
