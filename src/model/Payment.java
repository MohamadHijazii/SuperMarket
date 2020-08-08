package model;
import java.util.Date;

public class Payment {

	// COMPOSITE KEY customerNumber and checkNumber
	public int customerNumber;
	public Customer customer;
	public String checkNumber;
	public Date paymentDate;
	public double amount;
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

	
	public static Payment getPaymentWithId(int c_id,String check_id) {
		DB db = DB.getInstance();
		for(Payment p: db.payments) {
			if(p.customerNumber == c_id && p.checkNumber.compareTo(check_id) == 0){
				return p;
			}
		}
		return null;
	}
	
	
}
