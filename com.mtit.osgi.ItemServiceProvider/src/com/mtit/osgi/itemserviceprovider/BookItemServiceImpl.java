package com.mtit.osgi.itemserviceprovider;

import java.util.List;

public class BookItemServiceImpl implements BookItemService{

	@Override
	public String publishBooks() {
		// TODO Auto-generated method stub
		return "Execute the BookItemService";
	}

	@Override
	public int testBookItem(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String displayBooksDetail(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayAllItems() {
		// TODO Auto-generated method stub
		return null;
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
