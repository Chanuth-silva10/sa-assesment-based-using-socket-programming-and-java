package addtocartserviceprovider;

import java.util.List;

public interface AddToCartService {
	
	
public boolean addtoCart(String bName, String bDesc, double bQty, String bCategory, double bPrice, double availQty);
	
	
	public List getCart();
	
	
	public double getCartTotal();
	
	
	public String printCartSummary();

	
	public int getCartCount();
	
	
	public boolean removeProduct(int index);
	
	
	public boolean clearCart();
	
	
	public String getProductName(int index);
	
	
	public int checkCart(String name);
}
