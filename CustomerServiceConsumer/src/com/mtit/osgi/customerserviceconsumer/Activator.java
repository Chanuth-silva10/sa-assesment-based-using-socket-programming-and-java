package com.mtit.osgi.customerserviceconsumer;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.addtocartserviceprovider.AddToCartService;
import com.mtit.osgi.itemserviceprovider.BookItemService;
import com.mtit.osgi.orderservicepublisher.*;
import com.mtit.osgi.itemserviceprovider.BookItemService;



public class Activator implements BundleActivator {
	
	ServiceReference serviceReferenceBookItem;
	ServiceReference serviceReferenceAddToCart;
	ServiceReference serviceReferenceOrder;
	BookItemService BookItemService;
	AddToCartService addToCartService;
	CusOrderService CusOrderService;
	
	Scanner sc = new Scanner(System.in);
    

	public void start(BundleContext context) throws Exception {
		
		System.out.println(Constant.WELCOME);
		
		serviceReferenceBookItem = context.getServiceReference(BookItemService.class.getName());
		BookItemService = (BookItemService) context.getService(serviceReferenceBookItem);

		serviceReferenceAddToCart = context.getServiceReference(AddToCartService.class.getName());
		addToCartService = (AddToCartService) context.getService(serviceReferenceAddToCart);

		serviceReferenceOrder = context.getServiceReference(CusOrderService.class.getName());
		CusOrderService = (CusOrderService) context.getService(serviceReferenceOrder);

		int index = 0;
		int option;
		String name, details, cart, input;
		

				do {
					
					System.out.println("\n" + Constant.MAINMENU);
					System.out.println("\n" + Constant.OPTION1);
					System.out.println(Constant.OPTION2);
					System.out.println(Constant.OPTION3);
					System.out.println(Constant.OPTION4);
					System.out.println(Constant.OPTION5);
					System.out.println(Constant.OPTION6);
					System.out.println(Constant.OPTION7);

					
					while (true) {
						try {
							System.out.print("\n" + Constant.SELECTOPTION);
							option = sc.nextInt();
							break;
							
						} catch (InputMismatchException e) {
							System.out.println(Constant.INVALIDOPTION);
							sc.next();
						}
					}

					
					switch (option) {

					
					case 1:
						System.out.println("\n" + Constant.ALLPRODUCTS);
						System.out.println(BookItemService.displayAllBookItems());
						System.out.println(Constant.ENTEROPTIONNUM);

					
						while (true) {
							
							while (true) {
								try {
									System.out.print("\n" + Constant.ENTERPNUM);
									index = sc.nextInt();
									
									if (index < 0 || index > BookItemService.getBookItemCount()) {
										System.out.println(Constant.INVALIDOPTION);
									} else {
										break;
									}
									
								} catch (InputMismatchException e) {
									System.out.println(Constant.INVALIDOPTION);
									sc.next();
								}
							}
							if (index == 0) {
								break;
							}

							index = index - 1;
							
							addtoCart(index);
							
							while (true) {
								System.out.print(Constant.ADDMORE);
								input = sc.next().toLowerCase();
								
								if (input.equals(Constant.YES) || input.equals(Constant.NO)) {
									break;
								} else {
									System.out.println(Constant.INVALIDOPTION);
								}
							}
							if(input.equals(Constant.NO)) {
								break;
							}

						}
						break;

					case 2:
						
						do {
							System.out.println(Constant.SEARCHPRODUCT);
							name = sc.next();
							if (name.equals("0")) {
								break;
							}
							index = BookItemService.testBookItem(name);
							
							if (index == -1) {
								System.out.println(Constant.NOTFOUND);
							}
						} while (index == -1);

						if (!name.equals("0")) {

							
							details = BookItemService.displayBookDetail(index);
							System.out.println(details);

							
							while (true) {

								System.out.print(Constant.ADDTOCART);
								cart = sc.next().toLowerCase();
								
								if (cart.equals(Constant.YES) || cart.equals(Constant.NO)) {
									break;
								} else {
									System.out.println(Constant.INVALIDOPTION);
								}
							}

							if (cart.equals(Constant.YES)) {
								addtoCart(index);
							} else {
								
								while (true) {
									System.out.print("\n" + Constant.CHECKOUT);
									input = sc.next().toLowerCase();

									if (!input.equals(Constant.CHECK) && !input.equals(Constant.BACK)) {
										System.out.println(Constant.INVALIDOPTION);
									} else {
										break;
									}
								}
								
								if (input.equals(Constant.CHECK)) {
									checkOut();
									break;
								} else if (input.equals(Constant.BACK)) {
									break;
								}
							}
						}
						break;

					case 3:
						
						System.out.println("\n" + addToCartService.printCartDetails());
						break;

				
					case 4:
						
						while (true) {
							// Print the Cart Summary
							System.out.println("\n" + addToCartService.printCartDetails());

							// Checks if the cart is empty
							if (addToCartService.getAddToCartCount() == 0) {
								break;
							}
							while (true) {
								try {
									System.out.print(Constant.REMOVEPNUM);
									index = sc.nextInt();
									// Checks if the input is valid
									if (index < 0 || index > addToCartService.getAddToCartCount()) {
										System.out.println(Constant.INVALIDOPTION);
									} else {
										break;
									}

									// Catches the exception that will be thrown if a String is entered
								} catch (InputMismatchException e) {
									System.out.println(Constant.INVALIDOPTION);
									sc.next();
								}
							}

							// Exit if the input is 0
							if (index == 0) {
								break;
							}
							index = index - 1;
							// Loop until a valid input is entered
							while (true) {
								System.out.print("Do you want to remove " + addToCartService.getBookIteName(index)
										+ " from the cart ? (y/n) : ");
								input = sc.next();
								if (input.toLowerCase().equals(Constant.YES) || input.toLowerCase().equals(Constant.NO)) {
									break;
								}
								System.out.println(Constant.INVALIDOPTION);
							}
							// Checks if user needs to remove more products
							if (input.toLowerCase().equals(Constant.YES)) {
								// Checks if the removal is successful
								if (addToCartService.removeBookItem(index)) {
									System.out.println(Constant.REMOVESUCCESS);
								} else {
									System.out.println(Constant.REMOVEFAIL);
								}
								// Loop until a valid input is entered
								while (true) {
									System.out.print(Constant.REMOVEMORE);
									input = sc.next();
									if (input.toLowerCase().equals(Constant.YES) || input.toLowerCase().equals(Constant.NO)) {
										break;
									}
									System.out.println(Constant.INVALIDOPTION);
								}
								// Check if user wants to remove more products
								if (input.toLowerCase().equals(Constant.NO)) {
									break;
								}
							}
						}
						break;
					// Clears the cart
					case 5:
						// Prints the cart summary
						System.out.println("\n" + addToCartService.printCartDetails());
						// Check if cart is not empty
						if (addToCartService.getAddToCartCount() > 0) {
							// Loop until a valid input is entered
							while (true) {
								System.out.print(Constant.EMPTYCART);
								input = sc.next().toLowerCase();
								if (input.equals(Constant.YES) || input.equals(Constant.NO)) {
									break;
								}
								System.out.println(Constant.INVALIDOPTION);
							}
							// Check if user needs to clear the cart
							if (input.equals(Constant.YES)) {
								if (addToCartService.clearAddToCart()) {
									System.out.println(Constant.EMPTYCARTSUCCESS);
								} else {
									System.out.println(Constant.EMPTYCARTFAIL);
								}
							}
						}
						break;
					// checkout
					case 6:
						checkOut();
						break;
					// Exit
					case 7:
						System.out.println(Constant.THANKYOU);
						break;
					default:
						System.out.println("\n" + Constant.INVALIDOPTION);
					}

				} while (option != 7);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println(Constant.GOODBYE);
		context.ungetService(serviceReferenceBookItem);
		context.ungetService(serviceReferenceAddToCart);
		context.ungetService(serviceReferenceOrder);
	}
	
	public void addtoCart(int index) {
		int qty,availQty;
		double price;
		String name, desc,category;

		
		name = BookItemService.getBookItemName(index);
		
		desc = BookItemService.getDesc(index);
		
		category = BookItemService.getCaategory(index);
		
		availQty = BookItemService.getQty(index);
		
		price = BookItemService.getBookPrice(index);
		
		
            
		while (true) {
			try {
				System.out.print(Constant.ENTERQTY);
				qty = sc.nextInt();
				if (qty > 0) {
					break;
				} else {
					System.out.println(Constant.INVALIDOPTION);
				}
				// Catches the exception that will be thrown if a String is entered
			} catch (InputMismatchException e) {
				System.out.println(Constant.INVALIDOPTION);
				sc.next();
			}
		}

		// Checks whether the required quantity is less than the available quantity
		if (qty > 0 && qty <= availQty) {
			// Checks if the product is added to the cart successfully
			if (addToCartService.addtoCart(name, desc, qty, category, price, availQty)) {
				System.out.println(qty + "  of " + name + Constant.SUCCESSFULLYADDED);
			} else {
				System.out.println(Constant.NOTAVAILABLE + "Only " + availQty + "item are available.");
			}

		} else {
			System.out.println(Constant.NOTAVAILABLE + " Only " + availQty + "items are available.");
		}

	}
    
	/**
	 * Checkout the customer and places the order
	 */
	public void checkOut() {
		
		String orderConfirm, cname, address, city, contact;
		
		// Prints the cart summary
		System.out.println("\n" + addToCartService.printCartDetails());

		// Checks if the cart is empty
		if (addToCartService.getAddToCartCount() != 0) {

			
			/// Loops until a valid input is entered
			while (true) {
				System.out.print(Constant.CONFIRMORCANCEL);
				orderConfirm = sc.next();
				if (!orderConfirm.toLowerCase().equals(Constant.CONFIRM)
						&& !orderConfirm.toLowerCase().equals(Constant.BACK)) {
					System.out.println(Constant.INVALIDOPTION);
				} else {
					break;
				}
			}
			// Checks if user confirms
			if (orderConfirm.toLowerCase().equals(Constant.CONFIRM)) {
				// Requests to enter the customer details
				System.out.println(Constant.ENTERNAME);
				cname = sc.next();
				System.out.println(Constant.ENTERCONTACT);
				contact = sc.next();
				System.out.println(Constant.ENTERADDRESS);
				sc.nextLine();
				address = sc.nextLine();
				System.out.println(Constant.ENTERCITY);
				city = sc.next();
				double total = addToCartService.getCartTotal();

				// Checks is the order confirmation is successful
				if (CusOrderService.confirmCustomerOrder(addToCartService.getCart(), new Customer(cname, contact, address), total)) {
					System.out.println(
							Constant.ORDERSUCCESS + "Please keep Rs." + total + " ready at the time of delivery.");
					// Reduces the available quantity of the products
					BookItemService.decreaseQty(addToCartService.getCart());
					// Clears the cart
					addToCartService.clearAddToCart();
				} else {
					System.out.println(Constant.ORDERFAIL);
				}

			}
		}
	}


}
