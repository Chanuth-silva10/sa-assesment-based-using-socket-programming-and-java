package com.mtit.osgi.itemserviceprovider;

import java.util.List;

public interface BookItemService {
	
    public String publishBooks();
     
    
 	public int testBookItem(String name);
 	
 	
 	public String displayBookDetail(int index);
 	
 	
 	public String displayAllBookItems();
 	
 	
 	public int getQty(int index);
 	
 	
 	public String getDesc(int index);
 	
 	
 	public String getCaategory(int index);
 	
 	
 	public boolean decreaseQty(List<Item> orderedProducts);
 	
 	
 	public double getBookPrice(int index);
 	
 	
 	public boolean addBookItem(Item p);
 	
 	
 	public boolean deleteBookItem(int index);
 	
 	
 	public int getBookItemCount();

 	
 	public String getBookItemName(int index);
 	
 	
 	public boolean editBookName(int index, String name);
 	
 	
 	public boolean editBookQty(int index, int qty);
 	
 	
 	public boolean editBookPrice(int index, double price);
 	
	
	public boolean editBookCategory(int index, String category);
	
	
	public boolean editBookDesc(int index, String desc); 
 	
 	
}


