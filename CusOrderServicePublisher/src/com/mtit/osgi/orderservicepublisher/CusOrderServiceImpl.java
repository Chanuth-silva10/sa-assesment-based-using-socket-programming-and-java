package com.mtit.osgi.orderservicepublisher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.mtit.osgi.itemserviceprovider.Item;

public class CusOrderServiceImpl implements CusOrderService {



	private static final String CUSTOMERORDERDETAILS = "**********Customer Order Details **********";
	private static final String RS = "Rs.";
	private static final String PRODUCTS = "Products";
	private static final String CUSTOMERDETAILS = "Customer Details";
	private static final String CUSTOMERNAME = "Name : ";
	private static final String CUSTOMERCONTACT = "Contact No : ";
	private static final String CUSTOMERADDRESS = "Address : ";
	private static final String TOTAL = "Grand Total : ";
	private static final String CUSTOMERORDERNO = "Order No:";

	
	private List<CusOrder> cusOrders = new ArrayList<>();

	
	@Override
	public boolean confirmCustomerOrder(List<Item> items, Customer c, double total) {

		
		List<Item> orderedItems = (List<Item>) ((ArrayList<Item>) items).clone();
		
		Collections.copy(orderedItems, items);
		
		cusOrders.add(new CusOrder(orderedItems, c, total));
		return true;

	}

	
	@Override
	public String displayCustomerOrders() {
		String orderDetails;

		
		if (cusOrders.size() > 0) {
			orderDetails = "\n" + CUSTOMERORDERDETAILS + "\n\n";
			int i = 1;
			
			for (CusOrder o : cusOrders) {
				orderDetails += i + "." + CUSTOMERORDERNO + o.getOrderNo() + "\n\n";
				orderDetails += PRODUCTS + " - \n";
				
				for (Item item : o.getItems()) {
					orderDetails += item.getbName() + "\t" + item.getbQty() +  "\t" + RS
							+ item.getbPrice() * item.getbQty() + "\n";
				}
				//Display Customer Details
				orderDetails += "\n" + CUSTOMERDETAILS + " - \n";
				orderDetails += CUSTOMERNAME + o.getCus().getCusName() + "\n";
				orderDetails += CUSTOMERCONTACT + o.getCus().getCusContact() + "\n";
				orderDetails += CUSTOMERADDRESS + o.getCus().getCusAddress() + "\n";
				orderDetails += TOTAL + RS + o.getTotal() + "\n\n";
				i++;
			}
		} else {
			orderDetails = "No order created yet.";
		}
		return orderDetails;
	}

}
