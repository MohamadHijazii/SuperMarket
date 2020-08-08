package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	
	public static DB instance;
	Connection con;
	
	ArrayList<Customer> customers;
	ArrayList<Employee> employees;
	ArrayList<Office> offices;
	ArrayList<Order> orders;
	ArrayList<OrderDetails> orderDetails;
	ArrayList<Payment> payments;
	ArrayList<Product> products;
	ArrayList<Productlines> productLines;
	
	private DB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	//ma tod2ara zabta
			 String m_Connection="jdbc:sqlserver://DESKTOP-BHRFKKQ:1433;databaseName=SMarketDB;user=mhamad;password=***;";
			 con = DriverManager.getConnection(m_Connection); 
			 System.out.println("connection created!");
			 }
			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("No connection!");
			}
		customers = new ArrayList<>();
		employees = new ArrayList<>();
		offices = new ArrayList<>();
		orders = new ArrayList<>();
		orderDetails = new ArrayList<>();
		payments = new ArrayList<>();
		products = new ArrayList<>();
		productLines = new ArrayList<>();
		
	}
	
	public static DB getInstance() {
		if(instance == null) {
			instance = new DB();
		}
		return instance;
	}

	public ResultSet ExecuteQuery(String query) {
		ResultSet r = null;
		try {
			Statement st = con.createStatement();
			r = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public void getDataFromRDB() {
		//retreive data
		getCostumers();
		getEmployees();
		getOffices();
		getOrders();
		getOrdersDetails();
		getPayments();
		getProducts();
		getProductLines();
		
		//setForeign keys
		setCostumersFK();
		setEmployeeFK();
		setOrderFK();
		setOrdersDetailsFK();
		setPaymentsFK();
		setProductFK();
		
		
	}
	
	private void getCostumers() {
		ResultSet r = instance.ExecuteQuery("select * from customers");
		try {
			while(r.next()) {
					Customer c = new Customer(r.getInt("customerNumber"), r.getString("customerName"), r.getString("contactLastName"), r.getString("contactFirstName"), r.getString("phone"),r.getString("addressLine1"),r.getString("addressLine2"),r.getString("city"),r.getString("state"), r.getString("postalCode"), r.getString("country"),r.getInt("salesRepEmployeeNumber"),r.getDouble("creditLimit"));
					customers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setCostumersFK() {
		for(Customer c : customers) {
			Employee e = Employee.getEmployeeWithId(c.salesRepEmployeeNumber);
			if(c!= null)
				c.employee = e;
			if(e!=null)
				e.customers.add(c);
		}
	}
	
	private void getEmployees() {
		ResultSet r = instance.ExecuteQuery("select * from employees");
		try {
			while(r.next()) {
					Employee e = new Employee(r.getInt("employeeNumber"), r.getString("lastName"), r.getString("firstName"), r.getString("extension"), r.getString("email"), r.getString("officeCode"),r.getInt("reportsTo"), r.getString("jobTitle"));
					employees.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setEmployeeFK() {
		for(Employee e : employees) {
			Office o = Office.getOfficeWithId(e.officeCode);
			e.office = o;
			o.employees.add(e);
			Employee r = Employee.getEmployeeWithId(e.reportsTo);
			e.employee = r;
			if(r!= null)
				r.reporting.add(e);
		}
	}
	
	private void getOffices() {
		ResultSet r = instance.ExecuteQuery("select * from offices");
		try {
			while(r.next()) {
				Office o = new Office(r.getString("officeCode"), r.getString("city"), r.getString("phone"), r.getString("addressLine1"),r.getString("addressLine2"),r.getString("state"), r.getString("country"), r.getString("postalCode"), r.getString("territory"));
				offices.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void getOrders() {
		ResultSet r = instance.ExecuteQuery("select * from orders");
		try {
			while(r.next()) {
				Order o = new Order(r.getInt("orderNumber"), r.getDate("orderDate"),r.getDate("requiredDate"), r.getDate("shippedDate"),r.getString("status"), r.getString("comments"), r.getInt("customerNumber"));
				orders.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setOrderFK() {
		for(Order o : orders) {
			Customer c = Customer.getCostumerWithId(o.customerNumber);
			o.customer = c;
			c.orders.add(o);
		}
	}
	
	private void getOrdersDetails() {
		ResultSet r = instance.ExecuteQuery("select * from orderdetails");
		try {
			while(r.next()) {
				OrderDetails o = new OrderDetails(r.getInt("orderNumber"),r.getString("productCode"),r.getInt("quantityOrdered"),r.getDouble("priceEach"),r.getInt("orderLineNumber"));
				orderDetails.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setOrdersDetailsFK() {
		for(OrderDetails o : orderDetails) {
			Product p = Product.getProductWithId(o.productCode);
			o.product = p;
			Order or = Order.getOrderWithId(o.orderNumber);
			or.orderDetails.add(o);
			o.order = or;
		}
	}
	
	private void getPayments() {
		ResultSet r = instance.ExecuteQuery("select * from payments");
		try {
			while(r.next()) {
				Payment p = new Payment(r.getInt("customerNumber"), r.getString("checkNumber"),r.getDate("paymentDate"),r.getDouble("amount"));
				payments.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setPaymentsFK() {
		for(Payment p : payments) {
			Customer c = Customer.getCostumerWithId(p.customerNumber);
			p.customer = c;
			c.payments.add(p);
		}
	}
	
	private void getProducts() {
		ResultSet r = instance.ExecuteQuery("select * from products");
		try {
			while(r.next()) {
				Product p = new Product(r.getString("productCode"), r.getString("productName"),r.getString("productLine"),r.getString("productScale"), r.getString("productVendor"), r.getString("productDescription"), r.getInt("quantityInStock"),r.getDouble("buyPrice"), r.getDouble("mSRP"));
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void setProductFK() {
		for(Product p : products) {
			Productlines pl = Productlines.getProductLineWithId(p.productLines);
			p.productLinesObject = pl;
			pl.product = p;
		}
	}
	
	private void getProductLines() {
		ResultSet r = instance.ExecuteQuery("select * from productlines");
		try {
			while(r.next()) {
				Productlines p = new Productlines(r.getString("productLine"),r.getString("textDescription"), r.getString("htmlDescription"), r.getString("mediumblob"));
				productLines.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void printAll(ResultSet r) {
		try {
		ResultSetMetaData rsmd = r.getMetaData();
		   int columnsNumber = rsmd.getColumnCount();
		   while (r.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           String columnValue = r.getString(i);
		           System.out.print(rsmd.getColumnName(i)+": "+columnValue+"  ");
		       }
		       System.out.println("");
		   }
		}
		catch(Exception e) {
			
		}
	}
	
	
	
}
