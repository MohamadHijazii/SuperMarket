package model;
import java.util.ArrayList;

public class Office {

	public String officeCode;// PK
	public String city;
	public String phone;
	public String addressLine1;
	public String addressLine2;
	public String state;
	public String country;
	public String postalCode;
	public String territory;
	public ArrayList<Employee> employees;// one to many
	public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
		employees = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}

	public static Office getOfficeWithId(String id) {
		DB db = DB.getInstance();
		for(Office o: db.offices) {
			if(o.officeCode.compareTo(id) == 0){
				return o;
			}
		}
		return null;
	}
	
	
	
}
