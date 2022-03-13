package com.mtit.osgi.itemserviceprovider;

public class Item {
     private String bName;
     private String bDesc; 
	 private double bQty;
	 private double bCategory;
     private double bPrice;
     
    
 
	public Item(String bName, String bDesc, double bQty, double bCategory, double bPrice) {
		super();
		this.bName = bName;
		this.bDesc = bDesc;
		this.bQty = bQty;
		this.bCategory = bCategory;
		this.bPrice = bPrice;
	}



	public String getbName() {
		return bName;
	}



	public void setbName(String bName) {
		this.bName = bName;
	}



	public String getbDesc() {
		return bDesc;
	}



	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}



	public double getbQty() {
		return bQty;
	}



	public void setbQty(double bQty) {
		this.bQty = bQty;
	}



	public double getbCategory() {
		return bCategory;
	}



	public void setbCategory(double bCategory) {
		this.bCategory = bCategory;
	}



	public double getbPrice() {
		return bPrice;
	}



	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}

	
     
     
}
