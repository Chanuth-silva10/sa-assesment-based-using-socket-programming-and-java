package com.mtit.osgi.orderservicepublisher;


public class Customer {

	private String name;
	private String address;
	private String contact;
	
	/**
	 * Constructor of Customer class
	 * @param name
	 * @param contact
	 * @param address
	 * @param city
	 */
	public Customer(String name, String contact, String address) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
	
	}
	/**
	 * GetName method
	 * @return name
	 */
	public String getCusName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param name
	 */
	public void setCusName(String name) {
		this.name = name;
	}
	
	/**
	 * GetAddress method
	 * @return address
	 */
	public String getCusAddress() {
		return address;
	}
	
	/**
	 * Sets the address
	 * @param address
	 */
	public void setCusAddress(String address) {
		this.address = address;
	}


	public String getCusContact() {
		return contact;
	}

	/**
	 * Sets the contact
	 * @param contact
	 */
	public void setCusContact(String contact) {
		this.contact = contact;
	}
	
	
}

