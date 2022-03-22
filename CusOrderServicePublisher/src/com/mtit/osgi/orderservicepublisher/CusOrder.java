package com.mtit.osgi.orderservicepublisher;


import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;

public class CusOrder {

	
	private static int NO = 1;
	private int CusOrderNo;
	private Customer customer;
	private double total;
	
	private List<Item> Items;
	
	
	public CusOrder(List<Item> Items, Customer cus, double total) {
		super();
		this.CusOrderNo = NO++;
		this.Items = Items;
		this.customer = cus;
		this.total = total;
	}

	
	public int getOrderNo() {
		return CusOrderNo;
	}

	
	public void setOrderNo(int orderNo) {
		this.CusOrderNo = orderNo;
	}

	
	public List<Item> getItems() {
		return Items;
	}

	
	public void setItems(List<Item> Items) {
		this.Items = Items;
	}

	
	public Customer getCus() {
		return customer;
	}

	
	public void setCus(Customer cus) {
		this.customer = cus;
	}

	
	public double getTotal() {
		return total;
	}

	
	public void setTotal(double total) {
		this.total = total;
	}
}

