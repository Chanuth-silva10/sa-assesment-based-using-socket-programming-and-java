package com.mtit.osgi.itemserviceprovider;

import java.util.ArrayList;
import java.util.List;

public class BookItemServiceImpl implements BookItemService{

	@Override
	public String publishBooks() {
		// TODO Auto-generated method stub
		return "Execute the BookItemService";
	}
	
	private List<Item> items = new ArrayList<Item>() {
		{
			add(new Item("CR-80","Normal",15,"Story Book", 100.00));
			add(new Item("CR-160","Double Rool",10,"Story Book", 190.00));
			
		}
	};

	@Override
	public int testBookItem(String name) {
		
		int bCount = 0;
		
		for (Item item : items) {
			
			if (item.getbName().toLowerCase().equals(name.toLowerCase())) {
				return bCount;
			}
			bCount++;
		}
		
		bCount = -1;
		return bCount;
		
	}

	@Override
	public String displayBookDetail(int index) {
		return "Item Name : " + items.get(index).getbName() + ", Available Quantity : "
				+ items.get(index).getbQty() + ",Item Price : Rs. "  + items.get(index).getbPrice()
				+ ".........." ;
	}

	@Override
	public String displayAllBookItems() {
		String itemsDetails = "";
		
		if (items.size() > 0) {
			int bCount = 1;
			for (Item i : items) {
				itemsDetails += bCount + "    " + i.getbName() + "\t" + i.getbQty() + "\t" + "Rs."
						+ i.getbPrice() +"\t"+ i.getbCategory() + "\t" + i.getbDesc()+ "\n";
				bCount++;
			}
		} else {
			itemsDetails = "Items is a out of stock";
		}
		return itemsDetails;
	
	}

	@Override
	public double getQty(int i) {
		
		return items.get(i).getbQty();
		
	}

	@Override
	public boolean decreaseQty(List<Item> checkoutBooksDecrease) {
		
				for (Item item : items) {
					
					for (Item reduceItem : checkoutBooksDecrease) {
						
						if (reduceItem.getbName().toLowerCase().equals(reduceItem.getbName().toLowerCase())) {
							
							item.setbQty( item.getbQty() - reduceItem.getbQty());
						}
					}
				}

				return true;
	}

	@Override
	public double getBookPrice(int index) {
		return items.get(index).getbPrice();
		
	}

	@Override
	public boolean addBookItem(Item item) {
		items.add(item);
		return true;
	}

	@Override
	public boolean deleteBookItem(int i) {
		items.remove(i);
		return true;
	}

	@Override
	public int getBookItemCount() {
		return items.size();
	}

	@Override
	public String getBookItemName(int index) {
		return items.get(index).getbName();
	}

	@Override
	public boolean editBookName(int index, String name) {
		items.get(index).setbName(name);
		return true;
	}

	@Override
	public boolean editBookQty(int index, double qty) {
		items.get(index).setbQty(qty);
		return true;
	}

	@Override
	public boolean editBookPrice(int index, double price) {
		items.get(index).setbPrice(price);
		return true;
	}
	
	public boolean editBookCategory(int index, String category) {
		items.get(index).setbCategory(category);
		return true;
	}
	
	public boolean editBookDesc(int index, String desc) {
		items.get(index).setbDesc(desc);;
		return true;
	}

}
