package com.mtit.osgi.addtocartserviceprovider;

import java.util.List;

public interface AddToCartService {
	
	
    public boolean addtoCart(String bName, String bDesc, int bQty, String bCategory, double bPrice, int availQty);
	
	
	public List getCart();
	
	
	public double getCartTotal();
	
	
	public String printCartDetails();

	
	public int getAddToCartCount();
	
	
	public boolean removeBookItem(int index);
	
	
	public boolean clearAddToCart();
	
	
	public String getBookIteName(int index);
	
	
	public int checkAddToCart(String name);
}
