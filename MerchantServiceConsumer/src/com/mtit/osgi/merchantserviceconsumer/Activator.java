package com.mtit.osgi.merchantserviceconsumer;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.itemserviceprovider.BookItemService;
import com.mtit.osgi.itemserviceprovider.Item;
import com.mtit.osgi.orderservicepublisher.CusOrderService;


public class Activator implements BundleActivator {
    
	ServiceReference serviceReferenceItem;
	ServiceReference serviceReferenceOrder;
	
	
	public void start(BundleContext Context) throws Exception {
		System.out.println("OUR BOOKSHOP ADMIN ACCESS");
		serviceReferenceItem = Context.getServiceReference(BookItemService.class.getName());
		BookItemService bookItemService = (BookItemService)Context.getService(serviceReferenceItem);
		
		serviceReferenceOrder = Context.getServiceReference(CusOrderService.class.getName());
		CusOrderService orderService = (CusOrderService)Context.getService(serviceReferenceOrder);
		
		
		int nValue, iQty, itemIndex, eAnswer;
		String iName, iDesc, iCategory, dBookItem, answer, accept;
		double price;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("\n" + "WELCOME IMASHA");
			System.out.println("\n" + "----- MERCHANT PORTAL -----"+"\n");
			System.out.println("1) DISPLAY all BOOK ITEMS");
			System.out.println("2) DISPLAY all CUSTOMER ORDER");
			System.out.println("3) INSERT BOOK ITEM ");
			System.out.println("4) DELETE A BOOK ITEM");
			System.out.println("5) UPDATE A BOOK ITEM");
			System.out.println("6) EXIT THE MENU");

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
				//System.out.println("ID|\t|BookItem\t|Qty\t|Price\t\t|Category\t\t|describe\n");
				System.out.println(bookItemService.displayAllBookItems());
			} else if (nValue == 2) {
				System.out.println(orderService.displayCustomerOrders());
			} else if (nValue == 3) {			
				System.out.print("Enter the new book item : ");
				sc.nextLine();
				iName = sc.nextLine();
				
				while (true) {
					try {
						
						System.out.print("Enter Book Item description :  ");
						iDesc = sc.nextLine();
						if (iDesc.length() > 0) {
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
						
						System.out.print("Enter Book Item quantity  (as a no) : ");
						iQty = sc.nextInt();
						if (iQty > 0) {
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
						
						System.out.print("Enter Book Item Category :  ");
						iCategory = sc.next();
						if (iCategory.length() > 0) {
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
						System.out.print("Enter the unit price for one item:   ");
						price = sc.nextDouble();
						if (price > 0) {
							break;
						} else {
							System.out.println("Check the enter value. Please again enter a valid input ");
						}
						
					} catch (Exception e) {
						System.out.println("Please again enter a valid input");
						sc.next();
					}
				}
				
				if (bookItemService.addBookItem(new Item(iName, iDesc, iQty, iCategory, price))) {
					System.out.println("\n----------- Book item Adding Successfully ---------------");
				} else {
					System.out.println("Book item Adding not Successfully.Please try again.");
				}
			} else if (nValue == 4) {
				System.out.println(bookItemService.displayAllBookItems());
				System.out.print("Please enter the name of the Book item to delete : ");
				sc.nextLine();
				dBookItem = sc.nextLine();
				
				itemIndex = bookItemService.testBookItem(dBookItem);

			
				if (itemIndex != -1) {

					
					while (true) {
						System.out.print("Are you the  delete this Book item. please confirm ? (y/n) ");
						answer = sc.next().toLowerCase();

						if (answer.equals("y") || answer.equals("n")) {
							break;
						}
						System.out.println("Check the enter value. Please again enter a valid input");
					}
					
					if (answer.equals("y")) {
						
						if (bookItemService.deleteBookItem(itemIndex)) {
							System.out.println("Book item delete successfully");
						} else {
							System.out.println("Book item delete unSuccessfully");
						}
					}
				}else {
					System.out.println("Your enter product is not found .please check again");
				}

			} else if (nValue == 5) {
				
				while (true) {
					System.out.println("\n" + bookItemService.displayAllBookItems());

					
					while (true) {
						try {
							System.out.print("\nEnter Book item code :");
							itemIndex = sc.nextInt();

							
							if (itemIndex < 0 || itemIndex > bookItemService.getBookItemCount()) {
								System.out.println("Check the enter value. Please again enter a valid input");
							} else {
								break;
							}
							
						} catch (InputMismatchException e) {
							System.out.println("Check the enter value. Please again enter a valid input");
							sc.next();
						}
					}

					if (itemIndex == 0) {
						break;
					}
					itemIndex = itemIndex - 1;

					
					while (true) {
						System.out.print("Do you want to edit " + bookItemService.getBookItemName(itemIndex) + " ? (y/n) : \n");
						accept = sc.next();
						if (accept.equals("y") || accept.equals("n")) {
							break;
						}
						System.out.println("Check the enter value. Please again enter a valid input");
					}
					
					if (accept.equals("y")) {

						
						System.out.println(".............Under the below Update option.............\n");
						System.out.println("1) Update book item name    : ");
						System.out.println("2) Update book desc     : ");
						System.out.println("3) Update book qty      : ");
						System.out.println("4) Update book category : ");
						System.out.println("5) Update book price    : ");
						
						while (true) {
							try {
								System.out.print("\nEnter the value : ");
								eAnswer = sc.nextInt();

								
								if (eAnswer < 0 || eAnswer > 5) {
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
							
							System.out.print("Enter book item name : ");
							sc.nextLine();
							iName = sc.nextLine();
							
							if (bookItemService.editBookName(itemIndex, iName)) {
								System.out.println("Book item name update successfully!. ");
							} else {
								System.out.println("Book item name update unSuccessfully!. ");
							}
							break;
							
                        case 2:
							
							System.out.print("Enter book item description : ");
							sc.nextLine();
							iDesc = sc.nextLine();
							
							if (bookItemService.editBookDesc(itemIndex, iDesc)) {
								System.out.println("Book item description update successfully!. ");
							} else {
								System.out.println("Book item description update unSuccessfully!. ");
							}
							break;

						
							
						case 3:
							while (true) {
								try {
									System.out.print("Enter book Qty : ");
									iQty = sc.nextInt();
									
									if (iQty > 0) {
										break;
									} else {
										System.out.println("Check the enter value. Please again enter a valid input");

									}
								} catch (Exception e) {
									System.out.println("Check the enter value. Please again enter a valid input");

									sc.next();
								}
							}
							
							if (bookItemService.editBookQty(itemIndex, iQty)) {
								System.out.println("Book item Qty update successfully!. ");
							} else {
								System.out.println("Book item Qty update unSuccessfully!. ");
							}
							break;
							
                        case 4:
							
							System.out.print("Enter book Category : ");
							sc.nextLine();
							iDesc = sc.nextLine();
							
							if (bookItemService.editBookCategory(itemIndex, iDesc)) {
								System.out.println("Book item Catgory update successfully!. ");
							} else {
								System.out.println("Book item Category update unSuccessfully!. ");
							}
							break;
							
							
                        case 5:
							while (true) {
								try {

									System.out.print("Enter book price :");
									price = sc.nextDouble();
									
									if (price > 0) {
										break;
									} else {
										System.out.println("Check the enter value. Please again enter a valid input");
									}
								} catch (Exception e) {
									System.out.println("Check the enter value. Please again enter a valid input");
									sc.next();
								}
							}
							
							if (bookItemService.editBookPrice(itemIndex, price)) {
								System.out.println("Book item price update successfully!. ");
							} else {
								System.out.println("Book item price update unSuccessfully!. ");
							}
							break;

							
						}
						
						

						while (true) {
							System.out.print("Do you want to update another book item?.(y/n) ");
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
			} else if (nValue == 6) {
				System.out.println("Nice work!. Thank you. Good Bye.");
			}
		} while (nValue != 6);
	}

	public void stop(BundleContext Context) throws Exception {
		System.out.println("Good Bye");
	    Context.ungetService(serviceReferenceItem);
	}
	
	
	

}
