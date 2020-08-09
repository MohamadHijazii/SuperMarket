package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Product")
public class Product {

	public String productCode;// PK
	public String productName;

	public String productLines;// FK

	@OneToOne
	public Productlines productLinesObject;

	public String productScale;
	public String productVendor;
	public String productDescription;
	public int quantityInStock;
	public double buyPrice;
	public double MSRP;

	@OneToMany(mappedBy = "product")
	public List<OrderDetails> orderDetails;// one to many

	public Product() {
	}

	public Product(String productCode, String productName, String productLines, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLines = productLines;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
		orderDetails = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLines=" + productLines
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ MSRP + "]";
	}

	public static Product getProductWithId(String id) {
		DB db = DB.getInstance();
		for (Product p : db.products) {
			if (p.productCode.compareTo(id) == 0) {
				return p;
			}
		}
		return null;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLines() {
		return productLines;
	}

	public void setProductLines(String productLines) {
		this.productLines = productLines;
	}

	public Productlines getProductLinesObject() {
		return productLinesObject;
	}

	public void setProductLinesObject(Productlines productLinesObject) {
		this.productLinesObject = productLinesObject;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
