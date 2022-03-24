package com.mtit.osgi.addtocartserviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;
import com.mtit.osgi.itemserviceprovider.*;

public class AddToCartServiceImpl implements AddToCartService {

	private static final String CARTSUMMARY = "***** Cart Summary *****";
	private static final String TOTAL = "Total : ";
	private static final String CARTEMPTY = "Cart is empty";
	private static final String RS = "Rs.";

	private List<Item> cart = new ArrayList<>();

	
	@Override
	public boolean addtoCart(String bName, String bDesc, int bQty, String bCategory, double bPrice,int availBookQty) {

		
		int index = checkAddToCart(bName);

		if (index == -1) {
			cart.add(new Item(bName, bDesc, bQty, bCategory, bPrice));
		} else {
			int newQty = cart.get(index).getbQty() + bQty;

			if (newQty <= availBookQty) {
				cart.get(index).setbQty(newQty);
			} else {
				return false;
			}
		}
		return true;
	}

	
	@Override
	public List getCart() {
		return cart;
	}

	
	@Override
	public double getCartTotal() {
		double sum = 0;
		// Loops the products in the cart
		for (Item i : cart) {
			sum += i.getbPrice() * i.getbQty();
		}

		return sum;
	}

	
	@Override
	public String printCartDetails() {

		int c = 1;
		String details = "";
		if (cart.size() != 0) {
			details += CARTSUMMARY + "\n";

			for (Item i : cart) {
				details += c + ") " + i.getbName() + " " + i.getbQty() +"\t" + RS
						+ (i.getbPrice() * i.getbQty()) + "\n";
				c++;
			}
			details += "\n" + TOTAL + RS + getCartTotal() + "\n";

		} else {
			details += CARTEMPTY;
		}
		return details;
	}

	
	@Override
	public int getAddToCartCount() {
		return cart.size();
	}

	
	@Override
	public boolean removeBookItem(int index) {
		cart.remove(index);
		return true;
	}

	
	@Override
	public boolean clearAddToCart() {
		cart.clear();
		return true;
	}

	
	@Override
	public String getBookIteName(int index) {
		return cart.get(index).getbName();
	}

	
	@Override
	public int checkAddToCart(String bName) {

		int count = 0;
		for (Item i : cart) {
			if (i.getbName().toLowerCase().equals(bName.toLowerCase())) {
				return count;
			}
			count++;
		}

		return -1;
	}
}
