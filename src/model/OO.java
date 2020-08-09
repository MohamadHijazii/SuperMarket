package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OO {
	public static OO instance;
	EntityManagerFactory emf;
	EntityManager em;
	private OO() {
		openConnection();
	}
	
	public static OO getInstance() {
		if(instance == null)
			instance = new OO();
		return instance;
	}

	void openConnection() {
		emf = Persistence.createEntityManagerFactory("$objectdb/db/SuperMarket.odb");
		em = emf.createEntityManager();
	}

	public void SaveData() {
		em.getTransaction().begin();
		DB db = DB.getInstance();
		
		for(Customer data : db.customers) {
			em.persist(data);
		}
		
		for(Employee data : db.employees) {
			em.persist(data);
		}
		
		for(Office data : db.offices) {
			em.persist(data);
		}
		
		for(Order data : db.orders) {
			em.persist(data);
		}
		
		for(OrderDetails data : db.orderDetails) {
			em.persist(data);
		}
		
		for(Payment data : db.payments) {
			em.persist(data);
		}
		
		for(Product data : db.products) {
			em.persist(data);
		}
		
		for(Productlines data : db.productLines) {
			em.persist(data);
		}
		
		em.getTransaction().commit();
	}
	
}
