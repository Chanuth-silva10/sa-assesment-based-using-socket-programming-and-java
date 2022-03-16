package customerserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.osgi.itemserviceprovider.BookItemService;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {

		System.out.println(Strings.WELCOME);
		// Get a reference of the Product Service
		ServiceReference serviceReferBookItem = context.getServiceReference(BookItemService.class.getName());
		BookItemService bookItemService = (BookItemService) context.getService(serviceReferBookItem);

		// Get a reference of the Cart Service
		serviceReferAddToCart = context.getServiceReference(CartService.class.getName());
		cartService = (CartService) context.getService(serviceReferAddToCart);
        
		//------------

		int index = 0;
		int option;
		String name;
		String details;
		String cart;
		String input;

		// Loop until user exits
		do {
			// Print the main menu
			System.out.println("\n" + Strings.MAINMENU);
			System.out.println("\n" + Strings.OPTION1);
			System.out.println(Strings.OPTION2);
			System.out.println(Strings.OPTION3);
			System.out.println(Strings.OPTION4);
			System.out.println(Strings.OPTION5);
			System.out.println(Strings.OPTION6);
			System.out.println(Strings.OPTION7);

			// Loop until a valid input is entered
			while (true) {
				try {
					System.out.print("\n" + Strings.SELECTOPTION);
					option = sc.nextInt();
					break;
					// Catches the exception that will be thrown if a String is entered
				} catch (InputMismatchException e) {
					System.out.println(Strings.INVALIDOPTION);
					sc.next();
				}
			}

			// Display output based on the input
			switch (option) {

			// Display All Products
			case 1:
				System.out.println("\n" + Strings.ALLPRODUCTS);
				System.out.println(productService.displayAllProducts());
				System.out.println(Strings.ENTEROPTIONNUM);

				// Loop until user has finished adding items to the cart
				while (true) {
					// Loop until user enters the correct input
					while (true) {
						try {
							System.out.print("\n" + Strings.ENTERPNUM);
							index = sc.nextInt();
							// Check if Product number is valid
							if (index < 0 || index > productService.getProductCount()) {
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
					if (index == 0) {
						break;
					}

					index = index - 1;
					// Call the add to Cart method to add the product to the cart
					addtoCart(index);
					// Loop until user enters the correct input
					while (true) {
						System.out.print(Strings.ADDMORE);
						input = sc.next().toLowerCase();
						// Check if user needs to add more products to the cart
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
				// Loop until user finds a product
				do {
					System.out.println(Strings.SEARCHPRODUCT);
					name = sc.next();
					if (name.equals("0")) {
						break;
					}
					index = productService.testBookItem(name);
					// Check if product exists
					if (index == -1) {
						System.out.println(Strings.NOTFOUND);
					}
				} while (index == -1);

				if (!name.equals("0")) {

					// Display Product Details
					details = productService.displayBooksDetail(index);
					System.out.println(details);

					// Loop until user enters a valid input
					while (true) {

						System.out.print(Strings.ADDTOCART);
						cart = sc.next().toLowerCase();
						// Check if user needs to Add to Cart
						if (cart.equals(Strings.YES) || cart.equals(Strings.NO)) {
							break;
						} else {
							System.out.println(Strings.INVALIDOPTION);
						}
					}

					if (cart.equals(Strings.YES)) {
						addtoCart(index);
					} else {
						// Loop until a valid input is entered
						while (true) {
							System.out.print("\n" + Strings.CHECKOUT);
							input = sc.next().toLowerCase();

							if (!input.equals(Strings.CHECK) && !input.equals(Strings.BACK)) {
								System.out.println(Strings.INVALIDOPTION);
							} else {
								break;
							}
						}
						// Check if user wants to checkout
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
				// Print Cart Summary
				System.out.println("\n" + cartService.printCartSummary());
				break;

			// Remove a product from the cart
			case 4:
				// Loop until user has removed all the necessary products
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

}
