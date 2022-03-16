package addtocartserviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.mtit.osgi.itemserviceprovider.Item;
import com.mtit.osgi.itemserviceprovider.*;

public class AddToCartServiceImpl implements AddToCartService {

	private static final String CARTSUMMARY = "***** Cart Summary *****";
	private static final String TOTAL = "Total : ";
	private static final String CARTEMPTY = "Cart is empty";
	private static final String CURRENCY = "Rs.";
	private static final String WEIGHT = "kg";

	// List to store the products in the cart
	private List<Item> cart = new ArrayList<>();
dddddddddddddddddddd
	
	@Override
	public boolean addtoCart(String bName, String bDesc, double bQty, String bCategory, double bPrice,double availQty) {

		
		int index = checkCart(bName);

		if (index == -1) {
			cart.add(new Item(bName, bDesc, bQty, bCategory, bPrice));
		} else {
			double newQty = cart.get(index).getbQty() + bQty;

			if (newQty <= availQty) {
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

	/**
	 * Prints the details of the products in the cart
	 * 
	 * @return a String containing the details of the products in the cart
	 *
	 */
	@Override
	public String printCartSummary() {

		int count = 1;
		String summary = "";
		if (cart.size() != 0) {
			summary += CARTSUMMARY + "\n";

			for (Item i : cart) {
				summary += count + ") " + i.getbName() + " " + i.getbQty() +"\t" + CURRENCY
						+ (i.getbPrice() * i.getbQty()) + "\n";
				count++;
			}
			summary += "\n" + TOTAL + CURRENCY + getCartTotal() + "\n";

		} else {
			summary += CARTEMPTY;
		}
		return summary;
	}

	
	@Override
	public int getCartCount() {
		return cart.size();
	}

	
	@Override
	public boolean removeProduct(int index) {
		cart.remove(index);
		return true;
	}

	
	@Override
	public boolean clearCart() {
		cart.clear();
		return true;
	}

	
	@Override
	public String getProductName(int index) {
		return cart.get(index).getbName();
	}

	
	@Override
	public int checkCart(String name) {

		int count = 0;
		for (Item i : cart) {
			if (i.getbName().toLowerCase().equals(name.toLowerCase())) {
				return count;
			}
			count++;
		}

		return -1;
	}
}
