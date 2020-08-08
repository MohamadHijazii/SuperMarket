package model;
public class OrderDetails {

	// Many To Many Table
	// COMPOSITE KEY orderNumber and ProductCode
	public int orderNumber;// FK
	public Order order;
	public String productCode;// FK
	public Product product;
	public int quantityOrdered;
	public double priceEach;
	public int orderLineNumber;
	
	public OrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach,
			int orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderNumber=" + orderNumber + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}

	
	public static OrderDetails getOrderDetailsWithId(int id) {
		DB db = DB.getInstance();
		for(OrderDetails o: db.orderDetails) {
			if(o.orderNumber == id){
				return o;
			}
		}
		return null;
	}
	
}
