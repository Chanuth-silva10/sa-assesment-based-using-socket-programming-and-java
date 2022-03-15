package com.mtit.osgi.cartserviceprovider;

import java.util.List;

public interface CartService {
		
		
		public boolean addtoCart(String name, double qty,double price, double availQty);
		
		
		public List getCart();
		
		
		public double getCartTotal();
		
		
		public String printCartSummary();

		
		public int getCartCount();
		
		
		public boolean removeProduct(int index);
		
		
		public boolean clearCart();
		
		
		public String getProductName(int index);
		
		
		public int checkCart(String name);
}
