package model;
import java.util.ArrayList;
import java.util.Date;

public class Order {

	public int orderNumber;// PK
	public Date orderDate;
	public Date requiredDate;
	public Date shippedDate;
	public String status;
	public String comments;
	public int customerNumber; // FK
	public Customer customer;
	public ArrayList<OrderDetails> orderDetails;// one to many
	
	public Order(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments,
			int customerNumber) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
		orderDetails = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customerNumber="
				+ customerNumber + "]";
	}

	
	public static Order getOrderWithId(int id) {
		DB db = DB.getInstance();
		for(Order o: db.orders) {
			if(o.orderNumber == id){
				return o;
			}
		}
		return null;
	}
	
	
}
