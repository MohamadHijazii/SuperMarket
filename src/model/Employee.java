package model;
import java.util.ArrayList;

public class Employee {

	public int employeeNumber;// PK
	public String lastName;
	public String firstName;
	public String extension;
	public String email;
	public String officeCode;// FK
	public Office office;
	public int reportsTo;// FK
	public Employee employee;
	public String jobTitle;
	public ArrayList<Customer> customers;// one to many
	public ArrayList<Employee> reporting;
	
	public Employee(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, int reportsTo, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
		customers = new ArrayList<>();
		reporting = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}
	
	
	public static Employee getEmployeeWithId(int id) {
		DB db = DB.getInstance();
		for(Employee e: db.employees) {
			if(e.employeeNumber == id){
				return e;
			}
		}
		return null;
	}
	
	

}
