package financialserviceconsumer;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.employeeserviceprovider.Employee;
import com.mtit.osgi.employeeserviceprovider.EmployeeService;

public class Activator implements BundleActivator {

	ServiceReference serviceReferenceSalary;

	
	public void start(BundleContext context) throws Exception {
		System.out.println("Employee Salary Paymentation. ");
		
		serviceReferenceSalary = context.getServiceReference(EmployeeService.class.getName());
		EmployeeService employeeSalaryService = (EmployeeService)context.getService(serviceReferenceSalary);
		
		int nValue, eAge, empNo, eAnswer;
		String eName, eDesination, iCategory, employeeName, answer, accept;
		double eSalary;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("\n" + "....... WELCOME Salary Management for Employee ........");
			System.out.println("\n" + "----- Salary Management Portal -----");
			System.out.println("1) DISPLAY all Employees");
			System.out.println("2) SEARCH EMPLOYEE ");
			System.out.println("3) Pay Salary for Employee");
			System.out.println("4) EXIT THE MENU");

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
			
			if (nValue == 1) {
				System.out.println(employeeSalaryService.displayAllEmployees());
			}else if(nValue == 2) {
				
			}else if(nValue == 3) {
				
			} else if (nValue == 4) {
				System.out.println("This is a Employee Salalry Management portal. Thank you. Good Bye.");
			}
		} while (nValue != 4);
	}
		
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye");
	    context.ungetService(serviceReferenceSalary);
	}

}
