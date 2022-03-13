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
			add(new Item("A","A is a Story books",12,"Story Book", 150.00));
			add(new Item("A","A is a Story books",12,"Story Book", 150.00));
			
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
	public String displayAllItems() {
		String itemsDetails = "";
		
		if (items.size() > 0) {
			int bCount = 1;
			for (Item i : items) {
				itemsDetails += bCount + " " + i.getbName() + "\t" + i.getbQty() + "\t" + "Rs. "
						+ i.getbPrice() + "/" + "\n";
				bCount++;
			}
		} else {
			itemsDetails = "Items is a out of stock";
		}
		return itemsDetails;
	
	}

	@Override
	public double getQty(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean reduceQty(List<Item> orderedProducts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getPrice(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addItem(Item p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getItemName(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editName(int index, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editQty(int index, double qty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPrice(int index, double price) {
		// TODO Auto-generated method stub
		return false;
	}

}
