package com.mtit.osgi.itemserviceprovider;

import java.util.List;

public interface BookItemService {
	
    public String publishBooks();
     
    
 	public int testBookItem(String name);
 	
 	
 	public String displayBookDetail(int index);
 	
 	
 	public String displayAllItems();
 	
 	
 	public double getQty(int index);
 	
 	
 	public boolean reduceQty(List<Item> orderedProducts);
 	
 	
 	public double getPrice(int index);
 	
 	
 	public boolean addItem(Item p);
 	
 	
 	public boolean deleteItem(int index);
 	
 	
 	public int getItemCount();

 	
 	public String getItemName(int index);
 	
 	
 	public boolean editName(int index, String name);
 	
 	
 	public boolean editQty(int index, double qty);
 	
 	
 	public boolean editPrice(int index, double price);
 	
 	
}


