package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Employee")
public class Employee {

	public int employeeNumber;// PK
	public String lastName;
	public String firstName;
	public String extension;
	public String email;

	public String officeCode;// FK

	@ManyToOne(fetch = FetchType.LAZY)
	public Office office;

	public int reportsTo;// FK

	@ManyToOne(fetch = FetchType.LAZY)
	public Employee employee;

	public String jobTitle;

	@OneToMany(mappedBy = "employee")
	public List<Customer> customers;// one to many

	@OneToMany(mappedBy = "employee")
	public List<Employee> employees;// one to many

	public Employee() {
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getReporting() {
		return employees;
	}

	public void setReporting(ArrayList<Employee> reporting) {
		this.employees = reporting;
	}

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
		employees = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}

	public static Employee getEmployeeWithId(int id) {
		DB db = DB.getInstance();
		for (Employee e : db.employees) {
			if (e.employeeNumber == id) {
				return e;
			}
		}
		return null;
	}

}
