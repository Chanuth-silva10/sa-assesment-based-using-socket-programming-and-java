package com.mtit.osgi.orderservicepublisher;

import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;

public interface OrderService {

	public boolean confirmCustomerOrder(List<Item> items,Customer c, double total);
	
	public String displayCustomerOrders();
}
