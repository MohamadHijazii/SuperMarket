package model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "Productlines")
public class Productlines {

	public String productLine;// PK
	public String textDescription;
	public String htmlDescription;
	public String mediumblob;

	@OneToOne
	public Product product;// FK

	public Productlines() {
	}

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
		for (Productlines p : db.productLines) {
			if (p.productLine.compareTo(id) == 0) {
				return p;
			}
		}
		return null;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getMediumblob() {
		return mediumblob;
	}

	public void setMediumblob(String mediumblob) {
		this.mediumblob = mediumblob;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
