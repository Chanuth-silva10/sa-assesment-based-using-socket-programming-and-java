package com.mtit.osgi.orderservicepublisher;


import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;

public class Order {

	
	private static int NUM = 1;
	private int orderNo;
	private Customer cus;
	private double total;
	private List<Item> Items;
	
	
	public Order(List<Item> Items, Customer cus, double total) {
		super();
		this.orderNo = NUM++;
		this.Items = Items;
		this.cus = cus;
		this.total = total;
	}

	
	public int getOrderNo() {
		return orderNo;
	}

	
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	
	public List<Item> getItems() {
		return Items;
	}

	
	public void setItems(List<Item> Items) {
		this.Items = Items;
	}

	
	public Customer getCus() {
		return cus;
	}

	
	public void setCus(Customer cus) {
		this.cus = cus;
	}

	
	public double getTotal() {
		return total;
	}

	
	public void setTotal(double total) {
		this.total = total;
	}
}

