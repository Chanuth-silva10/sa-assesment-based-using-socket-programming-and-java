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
	
	ServiceReference serviceReferenceProduct;
	ServiceReference serviceReferenceCart;
	ServiceReference serviceReferenceOrder;
	BookItemService productService;
	AddToCartService cartService;
	OrderService orderService;
	Scanner sc = new Scanner(System.in);


	public void start(BundleContext context) throws Exception {
		
		System.out.println(Strings.WELCOME);
		
		serviceReferenceProduct = context.getServiceReference(BookItemService.class.getName());
		productService = (BookItemService) context.getService(serviceReferenceProduct);

		serviceReferenceCart = context.getServiceReference(AddToCartService.class.getName());
		cartService = (AddToCartService) context.getService(serviceReferenceCart);

		serviceReferenceOrder = context.getServiceReference(OrderService.class.getName());
		orderService = (OrderService) context.getService(serviceReferenceOrder);

		int index = 0;
		int option;
		String name, details, cart, input;
		

				do {
					
					System.out.println("\n" + Strings.MAINMENU);
					System.out.println("\n" + Strings.OPTION1);
					System.out.println(Strings.OPTION2);
					System.out.println(Strings.OPTION3);
					System.out.println(Strings.OPTION4);
					System.out.println(Strings.OPTION5);
					System.out.println(Strings.OPTION6);
					System.out.println(Strings.OPTION7);

					
					while (true) {
						try {
							System.out.print("\n" + Strings.SELECTOPTION);
							option = sc.nextInt();
							break;
							
						} catch (InputMismatchException e) {
							System.out.println(Strings.INVALIDOPTION);
							sc.next();
						}
					}

					
					switch (option) {

					
					case 1:
						System.out.println("\n" + Strings.ALLPRODUCTS);
						System.out.println(productService.displayAllBookItems());
						System.out.println(Strings.ENTEROPTIONNUM);

					
						while (true) {
							
							while (true) {
								try {
									System.out.print("\n" + Strings.ENTERPNUM);
									index = sc.nextInt();
									
									if (index < 0 || index > productService.getBookItemCount()) {
										System.out.println(Strings.INVALIDOPTION);
									} else {
										break;
									}
									
								} catch (InputMismatchException e) {
									System.out.println(Strings.INVALIDOPTION);
									sc.next();
								}
							}
							if (index == 0) {
								break;
							}

							index = index - 1;
							
							addtoCart(index);
							
							while (true) {
								System.out.print(Strings.ADDMORE);
								input = sc.next().toLowerCase();
								
								if (input.equals(Strings.YES) || input.equals(Strings.NO)) {
									break;
								} else {
									System.out.println(Strings.INVALIDOPTION);
								}
							}
							if(input.equals(Strings.NO)) {
								break;
							}

						}
						break;

					case 2:
						
						do {
							System.out.println(Strings.SEARCHPRODUCT);
							name = sc.next();
							if (name.equals("0")) {
								break;
							}
							index = productService.testBookItem(name);
							
							if (index == -1) {
								System.out.println(Strings.NOTFOUND);
							}
						} while (index == -1);

						if (!name.equals("0")) {

							
							details = productService.displayBookDetail(index);
							System.out.println(details);

							
							while (true) {

								System.out.print(Strings.ADDTOCART);
								cart = sc.next().toLowerCase();
								
								if (cart.equals(Strings.YES) || cart.equals(Strings.NO)) {
									break;
								} else {
									System.out.println(Strings.INVALIDOPTION);
								}
							}

							if (cart.equals(Strings.YES)) {
								addtoCart(index);
							} else {
								
								while (true) {
									System.out.print("\n" + Strings.CHECKOUT);
									input = sc.next().toLowerCase();

									if (!input.equals(Strings.CHECK) && !input.equals(Strings.BACK)) {
										System.out.println(Strings.INVALIDOPTION);
									} else {
										break;
									}
								}
								
								if (input.equals(Strings.CHECK)) {
									checkOut();
									break;
								} else if (input.equals(Strings.BACK)) {
									break;
								}
							}
						}
						break;

					case 3:
						
						System.out.println("\n" + cartService.printCartSummary());
						break;

				
					case 4:
						
						while (true) {
							// Print the Cart Summary
							System.out.println("\n" + cartService.printCartSummary());

							// Checks if the cart is empty
							if (cartService.getCartCount() == 0) {
								break;
							}
							while (true) {
								try {
									System.out.print(Strings.REMOVEPNUM);
									index = sc.nextInt();
									// Checks if the input is valid
									if (index < 0 || index > cartService.getCartCount()) {
										System.out.println(Strings.INVALIDOPTION);
									} else {
										break;
									}

									// Catches the exception that will be thrown if a String is entered
								} catch (InputMismatchException e) {
									System.out.println(Strings.INVALIDOPTION);
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
								System.out.print("Do you want to remove " + cartService.getProductName(index)
										+ " from the cart ? (y/n) : ");
								input = sc.next();
								if (input.toLowerCase().equals(Strings.YES) || input.toLowerCase().equals(Strings.NO)) {
									break;
								}
								System.out.println(Strings.INVALIDOPTION);
							}
							// Checks if user needs to remove more products
							if (input.toLowerCase().equals(Strings.YES)) {
								// Checks if the removal is successful
								if (cartService.removeProduct(index)) {
									System.out.println(Strings.REMOVESUCCESS);
								} else {
									System.out.println(Strings.REMOVEFAIL);
								}
								// Loop until a valid input is entered
								while (true) {
									System.out.print(Strings.REMOVEMORE);
									input = sc.next();
									if (input.toLowerCase().equals(Strings.YES) || input.toLowerCase().equals(Strings.NO)) {
										break;
									}
									System.out.println(Strings.INVALIDOPTION);
								}
								// Check if user wants to remove more products
								if (input.toLowerCase().equals(Strings.NO)) {
									break;
								}
							}
						}
						break;
					// Clears the cart
					case 5:
						// Prints the cart summary
						System.out.println("\n" + cartService.printCartSummary());
						// Check if cart is not empty
						if (cartService.getCartCount() > 0) {
							// Loop until a valid input is entered
							while (true) {
								System.out.print(Strings.EMPTYCART);
								input = sc.next().toLowerCase();
								if (input.equals(Strings.YES) || input.equals(Strings.NO)) {
									break;
								}
								System.out.println(Strings.INVALIDOPTION);
							}
							// Check if user needs to clear the cart
							if (input.equals(Strings.YES)) {
								if (cartService.clearCart()) {
									System.out.println(Strings.EMPTYCARTSUCCESS);
								} else {
									System.out.println(Strings.EMPTYCARTFAIL);
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
						System.out.println(Strings.THANKYOU);
						break;
					default:
						System.out.println("\n" + Strings.INVALIDOPTION);
					}

				} while (option != 7);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println(Strings.GOODBYE);
		context.ungetService(serviceReferenceProduct);
		context.ungetService(serviceReferenceCart);
		context.ungetService(serviceReferenceOrder);
	}
	
	public void addtoCart(int index) {
		double qty;
		double availQty;
		double price;

		// Gets the name of the product from the Product Service
		String name = productService.getBookItemName(index);
		// Gets the available quantity of the product from the Product Service
		availQty = productService.getQty(index);
		// Gets the price of the product from the Product Service
		price = productService.getBookPrice(index);

		while (true) {
			try {
				System.out.print(Strings.ENTERQTY);
				qty = sc.nextDouble();
				if (qty > 0) {
					break;
				} else {
					System.out.println(Strings.INVALIDOPTION);
				}
				// Catches the exception that will be thrown if a String is entered
			} catch (InputMismatchException e) {
				System.out.println(Strings.INVALIDOPTION);
				sc.next();
			}
		}

		// Checks whether the required quantity is less than the available quantity
		if (qty > 0 && qty <= availQty) {
			// Checks if the product is added to the cart successfully
			if (cartService.addtoCart(name, name, qty, name, price, availQty)) {
				System.out.println(qty + " kgs of " + name + Strings.SUCCESSFULLYADDED);
			} else {
				System.out.println(Strings.NOTAVAILABLE + "Only " + availQty + "kgs are available.");
			}

		} else {
			System.out.println(Strings.NOTAVAILABLE + " Only " + availQty + "kgs are available.");
		}

	}

	/**
	 * Checkout the customer and places the order
	 */
	public void checkOut() {
		
		String orderConfirm, cname, address, city, contact;
		
		// Prints the cart summary
		System.out.println("\n" + cartService.printCartSummary());

		// Checks if the cart is empty
		if (cartService.getCartCount() != 0) {

			
			/// Loops until a valid input is entered
			while (true) {
				System.out.print(Strings.CONFIRMORCANCEL);
				orderConfirm = sc.next();
				if (!orderConfirm.toLowerCase().equals(Strings.CONFIRM)
						&& !orderConfirm.toLowerCase().equals(Strings.BACK)) {
					System.out.println(Strings.INVALIDOPTION);
				} else {
					break;
				}
			}
			// Checks if user confirms
			if (orderConfirm.toLowerCase().equals(Strings.CONFIRM)) {
				// Requests to enter the customer details
				System.out.println(Strings.ENTERNAME);
				cname = sc.next();
				System.out.println(Strings.ENTERCONTACT);
				contact = sc.next();
				System.out.println(Strings.ENTERADDRESS);
				sc.nextLine();
				address = sc.nextLine();
				System.out.println(Strings.ENTERCITY);
				city = sc.next();
				double total = cartService.getCartTotal();

				// Checks is the order confirmation is successful
				if (orderService.confirmCustomerOrder(cartService.getCart(), new Customer(cname, contact, address), total)) {
					System.out.println(
							Strings.ORDERSUCCESS + "Please keep Rs." + total + " ready at the time of delivery.");
					// Reduces the available quantity of the products
					productService.decreaseQty(cartService.getCart());
					// Clears the cart
					cartService.clearCart();
				} else {
					System.out.println(Strings.ORDERFAIL);
				}

			}
		}
	}


}
