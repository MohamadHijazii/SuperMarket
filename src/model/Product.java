package model;
public class Product {

	public String productCode;// PK
	public String productName;
	public String productLines;// FK
	public Productlines productLinesObject;
	public String productScale;
	public String productVendor;
	public String productDescription;
	public int quantityInStock;
	public double buyPrice;
	public double MSRP;
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
		for(Product p: db.products) {
			if(p.productCode.compareTo(id) == 0){
				return p;
			}
		}
		return null;
	}
	
	
	
}
