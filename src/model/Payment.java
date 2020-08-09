package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name = "Payment")
public class Payment {

	// COMPOSITE KEY customerNumber and checkNumber
	public int customerNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	public Customer customer;

	public String checkNumber;
	public Date paymentDate;
	public double amount;

	public Payment() {
	}

	public Payment(int customerNumber, String checkNumber, Date paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}

	public static Payment getPaymentWithId(int c_id, String check_id) {
		DB db = DB.getInstance();
		for (Payment p : db.payments) {
			if (p.customerNumber == c_id && p.checkNumber.compareTo(check_id) == 0) {
				return p;
			}
		}
		return null;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
