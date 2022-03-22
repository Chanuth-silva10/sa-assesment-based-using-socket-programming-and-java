package com.mtit.osgi.managerserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.employeeserviceprovider.Employee;
import com.mtit.osgi.employeeserviceprovider.EmployeeService;



public class Activator implements BundleActivator {
    
	ServiceReference serviceReferenceItem;
	
	
	public void start(BundleContext Context) throws Exception {
		System.out.println("Employee Registration Panel. ");
		
		serviceReferenceItem = Context.getServiceReference(EmployeeService.class.getName());
		EmployeeService employeeService = (EmployeeService)Context.getService(serviceReferenceItem);
		
		
		int nValue, eAge, empNo, eAnswer;
		String eName, eDesination, iCategory, employeeName, answer, accept;
		double eSalary;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("\n" + "....... WELCOME Hasitha ........");
			System.out.println("\n" + "----- Employee Management Portal -----");
			System.out.println("1) DISPLAY all Employees");
			System.out.println("2) ADDING Employee ");
			System.out.println("3) DELETE Employee");
			System.out.println("4) UPDATE Employee");
			System.out.println("5) EXIT THE MENU");


			while (true) {
				try {
					System.out.print("\nPlease enter the value : ");
					nValue = sc.nextInt();
					
					if (nValue > 0 && nValue <= 6) {
						break;
					}
					System.out.println("Check the enter value. Please again enter a valid input");
					
				} catch (InputMismatchException e) {
					System.out.println("Please again enter a valid input");
					sc.next();
				}
			}
			
			if (nValue == 1) {
				System.out.println(employeeService.displayAllEmployees());
			} else if (nValue == 2) {			
				System.out.print("Enter the Employee Name : ");
				sc.nextLine();
				eName = sc.nextLine();
				
				while (true) {
					try {
						
						System.out.print("Enter Employee Desination :  ");
						eDesination = sc.nextLine();
						if (eDesination.length() > 0) {
							break;
						} else {
							System.out.println("Check the enter value. Please again enter a valid input");
						}						
					} catch (InputMismatchException e) {
						System.out.println("Please again enter a valid input");
						sc.next();
					}
				}
				
				while (true) {
					try {
						
						System.out.print("Enter Employee age :");
						eAge = sc.nextInt();
						if (eAge > 0) {
							break;
						} else {
							System.out.println("Check the enter value. Please again enter a valid input");
						}						
					} catch (InputMismatchException e) {
						System.out.println("Please again enter a valid input");
						sc.next();
					}
				}
				
				
				while (true) {
					try {
						System.out.print("Enter Employee Salary :  ");
						eSalary = sc.nextDouble();
						if (eSalary > 0) {
							break;
						} else {
							System.out.println("Check the enter value. Please again enter a valid input ");
						}
						
					} catch (Exception e) {
						System.out.println("Please again enter a valid input");
						sc.next();
					}
				}
				
				if (employeeService.addEmployee(new Employee(eName, eDesination, eAge, eSalary))) {
					System.out.println("\n----------- Employee Adding Successfully ---------------");
				} else {
					System.out.println("Book item Adding not Successfully.Please try again.");
				}
			} else if (nValue == 3) {
				System.out.println(employeeService.displayAllEmployees());
				System.out.print("Please enter the name of the Employee to delete : ");
				sc.nextLine();
				employeeName = sc.nextLine();
				
				empNo = employeeService.searchEmployee(employeeName);

			
				if (empNo != -1) {

					
					while (true) {
						System.out.print("Are you the  delete this employee . please confirm ? (y/n) ");
						answer = sc.next().toLowerCase();

						if (answer.equals("y") || answer.equals("n")) {
							break;
						}
						System.out.println("Check the enter value. Please again enter a valid input");
					}
					
					if (answer.equals("y")) {
						
						if (employeeService.deleteEmployee(empNo)) {
							System.out.println( employeeName + "   Employee delete successfully");
						} else {
							System.out.println("Employee delete unSuccessfully");
						}
					}
				}else {
					System.out.println("This Employee name is not found .please check again");
				}

			} else if (nValue == 4) {
				
				while (true) {
					System.out.println("\n" + employeeService.displayAllEmployees());

					
					while (true) {
						try {
							System.out.print("\nEnter Employee Code No : ");
							empNo = sc.nextInt();

							
							if (empNo < 0 || empNo > employeeService.getEmployeeCount()) {
								System.out.println("Check the enter value. Please again enter a valid input");
							} else {
								break;
							}
							
						} catch (InputMismatchException e) {
							System.out.println("Check the enter value. Please again enter a valid input");
							sc.next();
						}
					}

					if (empNo == 0) {
						break;
					}
					empNo = empNo - 1;

					
					while (true) {
						System.out.print("Do you want to edit " + employeeService.getEmployeeName(empNo) + " ? (y/n) : \n");
						accept = sc.next();
						if (accept.equals("y") || accept.equals("n")) {
							break;
						}
						System.out.println("Check the enter value. Please again enter a valid input");
					}
					
					if (accept.equals("y")) {

						
						System.out.println(".............Under the below Update option.............\n");
						System.out.println("1) Update Employee Name    : ");
						System.out.println("2) Update Employee Desination     : ");
						System.out.println("3) Update Employee Age     : ");
						System.out.println("4) Update Employee Salary : ");
						
						while (true) {
							try {
								System.out.print("\nEnter the value : ");
								eAnswer = sc.nextInt();

								
								if (eAnswer < 0 || eAnswer > 4) {
									System.out.println("Check the enter value. Please again enter a valid input");
								} else {
									break;
								}
								
							} catch (Exception e) {
								System.out.println("Check the enter value. Please again enter a valid input");
								sc.next();
							}
						}
						switch (eAnswer) {
						case 1:
							
							System.out.print("Enter Employee Updated Name :  ");
							sc.nextLine();
							eName = sc.nextLine();
							
							if (employeeService.editEmployeeName(empNo, eName)) {
								System.out.println("Employee name update successfully!. ");
							} else {
								System.out.println("Employee Name update unSuccessfully!.Please tyr again later. ");
							}
							break;
							
                        case 2:
							
							System.out.print("Enter Employee Desination  : ");
							sc.nextLine();
							eDesination = sc.nextLine();
							
							if (employeeService.editEmployeeDesination(empNo, eDesination)) {
								System.out.println("Employee Designation update successfully!. ");
							} else {
								System.out.println("Employee Designation  update unSuccessfully!. ");
							}
							break;

						
							
						case 3:
							while (true) {
								try {
									System.out.print("Enter Employee age  : ");
									eAge = sc.nextInt();
									
									if (eAge > 0) {
										break;
									} else {
										System.out.println("Check the enter value. Please again enter a valid input");

									}
								} catch (Exception e) {
									System.out.println("Check the enter value. Please again enter a valid input");

									sc.next();
								}
							}
							
							if (employeeService.editEmployeeAge(empNo, eAge)) {
								System.out.println("Employee Age update successfully!. ");
							} else {
								System.out.println("Employee Age update unSuccessfully!. ");
							}
							break;
						
							
                        case 4:
							while (true) {
								try {

									System.out.print("Enter Employee Salary : ");
									eSalary = sc.nextDouble();
									
									if (eSalary > 0) {
										break;
									} else {
										System.out.println("Check the enter value. Please again enter a valid input");
									}
								} catch (Exception e) {
									System.out.println("Check the enter value. Please again enter a valid input");
									sc.next();
								}
							}
							
							if (employeeService.editEmployeePrice(empNo, eSalary)) {
								System.out.println("Employee Salary update successfully!. ");
							} else {
								System.out.println("Employee Salary update unSuccessfully!. ");
							}
							break;

							
						}
						
						while (true) {
							System.out.print("Do you want to update another Employee?.(y/n) ");
							answer = sc.next();
							if (answer.equals("y") || answer.equals("n")) {
								break;
							}
							System.out.println("Check the enter value. Please again enter a valid input");
						}
						if (answer.equals("n")) {
							break;
						}
					}
				}
			} else if (nValue == 5) {
				System.out.println("This is a Employee admin portal. Thank you. Good Bye.");
			}
		} while (nValue != 5);
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Good Bye");
	    Context.ungetService(serviceReferenceItem);
	}
	
	
	

}
