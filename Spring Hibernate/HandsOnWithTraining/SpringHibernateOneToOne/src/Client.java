import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


public class Client {
	
	private static SessionFactory factory;
	
	//Obtain session factory
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getSessionFactory();
			Client client_1 = new Client();
			
			
			Address add1 = new Address ("Flemingo Road", "WAshington DC", "USA", "532");
			Employee emp1 = new Employee (3, "PRaveen", "Kumar", 4000, add1);
			emp1.setAddress(add1);
			client_1.insertData(emp1, add1);
			
			Address add2 = new Address ("KPHB", "Hyderabad", "IND", "50055");
			Employee emp2 = new Employee (4, "Honey", "Jasmine", 4000, add2);
			emp2.setAddress(add2);
			client_1.insertData(emp2, add2);
			
		} catch(HibernateException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	/* Insert into table*/
	public void insertData(Employee empObj, Address addObj)
	{
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(empObj);
		session.save(addObj);
		tx.commit();
		
		System.out.println("Both Employee and Address are inserted in the databae...");
		session.close();
	}
//	/Display from table/
	public void displayRecords() throws InterruptedException {
		Session session = factory.openSession();
		List empList = (List) session.createQuery("FROM Employee").list();
		for (Iterator iterator=empList.iterator(); iterator.hasNext(); ) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First name :"+emp.getFirstName());
			System.out.println("Last name :"+emp.getLastName());
			System.out.println("Salary :"+emp.getSalary());
			
			Address add = emp.getAddress();
			System.out.println("Address");
			System.out.println("\tStreet: " + add.getStreet());
			System.out.println("\tCity: "+add.getCity());
			System.out.println("\tState: "+add.getState());
			System.out.println("\tZipcode: : "+add.getZipcode());
		}
		session.close();
	}

}