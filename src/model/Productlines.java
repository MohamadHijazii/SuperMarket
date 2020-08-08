package model;
public class Productlines {

	public String productLine;// PK
	public String textDescription;
	public String htmlDescription;
	public String mediumblob;
	public Product product;// FK
	public Productlines(String productLine, String textDescription, String htmlDescription, String mediumblob) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.mediumblob = mediumblob;
	}
	@Override
	public String toString() {
		return "Productlines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", mediumblob=" + mediumblob + "]";
	}
	
	public static Productlines getProductLineWithId(String id) {
		DB db = DB.getInstance();
		for(Productlines p: db.productLines) {
			if(p.productLine.compareTo(id) == 0){
				return p;
			}
		}
		return null;
	}
}
