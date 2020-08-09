package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name = "OrderDetails")
public class OrderDetails {

	// Many To Many Table
	// COMPOSITE KEY orderNumber and ProductCode

	public int orderNumber;// FK

	@ManyToOne(fetch = FetchType.LAZY)
	public Order order;

	public String productCode;// FK

	@ManyToOne(fetch = FetchType.LAZY)
	public Product product;

	public int quantityOrdered;
	public double priceEach;
	public int orderLineNumber;

	public OrderDetails() {
	}

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
		for (OrderDetails o : db.orderDetails) {
			if (o.orderNumber == id) {
				return o;
			}
		}
		return null;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

}
