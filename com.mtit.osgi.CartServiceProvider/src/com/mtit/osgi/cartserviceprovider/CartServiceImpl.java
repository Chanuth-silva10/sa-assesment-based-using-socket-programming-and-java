package com.mtit.osgi.cartserviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;


public class CartServiceImpl implements CartService {

	@Override
	public boolean addtoCart(String name, double qty, double price, double availQty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCartTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String printCartSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCartCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeProduct(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearCart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getProductName(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkCart(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}