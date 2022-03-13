package com.mtit.osgi.itemserviceprovider;

public class Item {
     private String bName;
     private String bDesc; 
	 private double bQty;
     private double bPrice;
     
     public Item(String bName, double bQty, double bPrice) {
 		super();
 		this.bName = bName;
 		this.bQty = bQty;
 		this.bPrice = bPrice;
 	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}


	public double getbQty() {
		return bQty;
	}

	public void setbQty(double bQty) {
		this.bQty = bQty;
	}

	public double getbPrice() {
		return bPrice;
	}

	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}
     
     
     
}
