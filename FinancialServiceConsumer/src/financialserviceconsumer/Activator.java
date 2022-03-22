package financialserviceconsumer;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.employeeserviceprovider.Employee;
import com.mtit.osgi.employeeserviceprovider.EmployeeService;
import com.mtit.osgi.employeeserviceprovider.EmployeeSalary;


public class Activator implements BundleActivator {

	ServiceReference serviceReferenceSalary;
	EmployeeService employeeSalaryService;
	Scanner sc = new Scanner(System.in);
	

	
	public void start(BundleContext context) throws Exception {
		System.out.println("Employee Salary Paymentation. ");
		
		serviceReferenceSalary = context.getServiceReference(EmployeeService.class.getName());
		employeeSalaryService = (EmployeeService)context.getService(serviceReferenceSalary);
		
		int nValue, eAge, empNo, eAnswer, index ;
		String eName, eDesination, iCategory, employeeName, answer, accept, input,details;
		double eSalary;
		
		
		
		do {
			
			System.out.println("\n" + "....... WELCOME Salary Management for Employee ........");
			System.out.println("\n" + "----- Salary Management Portal -----\n");
			System.out.println("1) DISPLAY all Employees and Add Employee Salary.");
			System.out.println("2) SEARCH EMPLOYEE ");
			System.out.println("3) Displaye All Employee Salary Details ");
			System.out.println("4) EXIT THE MENU ");

			while (true) {
				try {
					System.out.print("\nPlease enter the value : ");
					nValue = sc.nextInt();
					
					if (nValue > 0 && nValue <= 4) {
						break;
					}
					System.out.println("Check the enter value. Please again enter a valid input");
					
				} catch (InputMismatchException e) {
					System.out.println("Please again enter a valid input");
					sc.next();
				}
			}
			
			switch(nValue) {
			
			case 1:
				System.out.println("\n ----- ALL Employee ------");
				System.out.println(employeeSalaryService.displayAllEmployees());
				System.out.println("Add Employee Salary entering their respective numbers, one at a time. Enter 0 to go back to the main Menu. ");

			
				while (true) {
					
					while (true) {
						try {
							System.out.print("\nEnter Employee No : ");
							index = sc.nextInt();
							
							if (index < 0 || index > employeeSalaryService.getEmployeeCount()) {
								System.out.println("Invalid Input. Please try again. ");
							} else {
								break;
							}
							
						} catch (InputMismatchException e) {
							System.out.println("Invalid Input. Please try again. ");
							sc.next();
						}
					}
					
					if (index == 0) {
						break;
					}

					index = index - 1;
					
					addEmployeeSalary(index);
					
					while (true) {
						System.out.print("Do you need to add another Employee Salary? (y/n) : ");
						input = sc.next().toLowerCase();
						
						if (input.equals("y") || input.equals("n")) {
							break;
						} else {
							System.out.println("Invalid Input, Please enter a valid input");
						}
					}
					if(input.equals("n")) {
						break;
					}

				}
				break;

			case 2:
				
				do {
					System.out.println("Please Enter the Employee Name to search or enter '0' to go back to the main menu: ");
					eName = sc.next();
					if (eName.equals("0")) {
						break;
					}
					index = employeeSalaryService.searchEmployee(eName);
					details = employeeSalaryService.displayEmployeeDetail(index);
					System.out.println(details);
					if (index == -1) {
						System.out.println("Not found Employee. ");
					}
				} while (index == -1);

				break;
				
			case 3:
				System.out.println("\n ----- ALL Employee ------");
				System.out.println(employeeSalaryService.displayAllEmployeeSalaryDetails());
				

				
					while (true) {
						System.out.print("Enter y to go back to the main menu => ");
						input = sc.next().toLowerCase();
						
						if (input.equals("y")) {
							break;
						} else {
							System.out.println("Invalid Input, Please enter a valid input");
						}
					}
					if(input.equals("n")) {
						break;
					}
					
				break;
			case 4:
				System.out.println("After the added employee details. You can Exit.");
				break;
			default:
				System.out.println("\n Invalid Input, Please enter a valid input");
			
			}
		} while (nValue != 4);
		
	}
		
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Buy Employee Salary Adminitration. ");
		context.ungetService(serviceReferenceSalary);
		
	}
	
	public void addEmployeeSalary(int index) {
		double eBasicSalary, eNetSalary, otRate;
		String eName, eDesignation, answer;
		int otHrs, age, checkAddSalary = 0;

		
		eName =  employeeSalaryService.getEmployeeName(index);
		System.out.println(eName);
		eBasicSalary = employeeSalaryService.getEmployeeSalary(index);
		System.out.println(eBasicSalary);
		eDesignation = employeeSalaryService.getEmployeeDesignation(index);
		System.out.println(eDesignation);
		age = employeeSalaryService.getEmployeAge(index);
		System.out.println(age);

		while (true) {
			try {
				System.out.print("Enter Ot Hourse : ");
				otHrs = sc.nextInt();
				System.out.print("Enter Ot Rate(%) : ");
				otRate = sc.nextDouble();
				
				if (otHrs > 1) {
					eNetSalary = eBasicSalary + (otHrs * otRate);
					System.out.println(eName + "  basic salry is "+eBasicSalary+  " and new  Salary updayed as a " + eNetSalary);
					
					
					
					if(employeeSalaryService.addSlary(eName, eDesignation, age, eBasicSalary, otHrs, otRate, eNetSalary)) {
						System.out.println("Employee Salary Added and Pay.");
						checkAddSalary = 1;
					} else {
						System.out.println("Added Unsuccefully. ");
					}
				} else {
					System.out.println("Please Enter valid Input. ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter valid Input. ");
				sc.next();
			}
			if(checkAddSalary == 1) {
				break;
			}
			
		}

		

	}

}
