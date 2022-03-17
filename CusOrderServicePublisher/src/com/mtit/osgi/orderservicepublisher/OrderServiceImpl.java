package com.mtit.osgi.orderservicepublisher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.mtit.osgi.itemserviceprovider.Item;

public class OrderServiceImpl implements OrderService {



	private static final String ORDERDETAILS = "********** Order Details **********";
	private static final String WEIGHT = "kg";
	private static final String CURRENCY = "Rs.";
	private static final String PRODUCTS = "Products";
	private static final String CUSTOMERDETAILS = "Customer Details";
	private static final String NAME = "Name : ";
	private static final String CONTACT = "Contact No : ";
	private static final String ADDRESS = "Address : ";
	private static final String CITY = "City : ";
	private static final String TOTAL = "Grand Total : ";
	private static final String NOORDERS = "No orders placed yet";
	private static final String ORDERNO = "Order No:";

	
	private List<Order> cusOrders = new ArrayList<>();

	
	@Override
	public boolean confirmCustomerOrder(List<Item> items, Customer c, double total) {

		
		List<Item> orderedItems = (List<Item>) ((ArrayList<Item>) items).clone();
		
		Collections.copy(orderedItems, items);
		
		cusOrders.add(new Order(orderedItems, c, total));
		return true;

	}

	
	@Override
	public String displayCustomerOrders() {
		String orderDetails;

		
		if (cusOrders.size() > 0) {
			orderDetails = "\n" + ORDERDETAILS + "\n\n";
			int i = 1;
			
			for (Order o : cusOrders) {
				orderDetails += i + "." + ORDERNO + o.getOrderNo() + "\n\n";
				orderDetails += PRODUCTS + " - \n";
				
				for (Item item : o.getItems()) {
					orderDetails += item.getbName() + "\t" + item.getbQty() +  "\t" + CURRENCY
							+ item.getbPrice() * item.getbQty() + "\n";
				}
				//Display Customer Details
				orderDetails += "\n" + CUSTOMERDETAILS + " - \n";
				orderDetails += NAME + o.getCus().getCusName() + "\n";
				orderDetails += CONTACT + o.getCus().getCusContact() + "\n";
				orderDetails += ADDRESS + o.getCus().getCusAddress() + "\n";
				orderDetails += TOTAL + CURRENCY + o.getTotal() + "\n\n";
				i++;
			}
		} else {
			orderDetails = NOORDERS;
		}
		return orderDetails;
	}

}
