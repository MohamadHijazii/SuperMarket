package model;

import java.util.ArrayList;

public class Customer {

	public int customerNumber;// PK
	public String customerName;
	public String contactLastName;
	public String contactFirstName;
	public String phone;
	public String addressLine1;
	public String addressLine2;
	public String city;
	public String state;
	public String postalCode;
	public String country;
	public int salesRepEmployeeNumber;// FK
	public Employee employee;
	public double creditLimit;
	public ArrayList<Order> orders;// one to many
	public ArrayList<Payment> payments;// one to many
	public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, int salesRepEmployeeNumber, double creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
		orders = new ArrayList<>();
		payments = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", salesRepEmployeeNumber="
				+ salesRepEmployeeNumber + ", creditLimit=" + creditLimit + "]";
	}
	
	public static Customer getCostumerWithId(int id) {
		DB db = DB.getInstance();
		for(Customer c : db.customers) {
			if(c.customerNumber == id) {
				return c;
			}
		}
		return null;
	}
	

}
