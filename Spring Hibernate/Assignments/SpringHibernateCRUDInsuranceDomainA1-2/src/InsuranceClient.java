import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class InsuranceClient {
	
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
			InsuranceClient client_1 = new InsuranceClient();
			
			//			/Add employees to the database/
			
//			 client_1.InsertRecordInDatabase(1,"Rohit",20,7000);
//			 client_1.InsertRecordInDatabase(2,"Surya",15,5000);
//			 client_1.InsertRecordInDatabase(3,"Charan",8,10000);
//			 client_1.InsertRecordInDatabase(4,"Muzammil",14,11000);
//			 client_1.InsertRecordInDatabase(5,"Rohan",20,9000);
//			 client_1.InsertRecordInDatabase(6,"Dilip",15,8000);
//			 client_1.InsertRecordInDatabase(7,"Abhi",7,12000);
//			 client_1.InsertRecordInDatabase(8,"Nikhil",6,6000);
//			 client_1.InsertRecordInDatabase(9,"Arjun",22,5000);
//			client_1.InsertRecordInDatabase(10,"Rakesh",16,6000);
			 
			
			client_1.DisplayRecords(); 
		
//			 client_1.DisplayRecords_NativeSQL(); 
			
			
			client_1.UpdateRecord(5, 10000);
			client_1.DisplayRecords();
			
			
		
			client_1.DeleteRecord(5);
			client_1.DisplayRecords();
			
			
//			client_1.DisplayRecords2();
			
		} catch(HibernateException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	/* Insert into table*/
	public void InsertRecordInDatabase(int policyNo, String name, int tenure, int amount) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Insurance ip = new Insurance(policyNo, name, tenure, amount);
		System.out.println("hiuii");
		session.save(ip);
		tx.commit();
		session.close();
	}
//	/Display from table/
	public void DisplayRecords() throws HibernateException {
		System.out.println("hey haii");
		Session session = factory.openSession();
		List proposerList = (List) session.createQuery("FROM Insurance").list();
		for (Iterator iterator=proposerList.iterator(); iterator.hasNext(); ) {
			Insurance proposer = (Insurance) iterator.next();
			System.out.println("Policy No :"+proposer.getPolicyNo());
			System.out.println("Proposer NAME :"+proposer.getName());
			System.out.print("Proposer Tenure:"+proposer.getTenure());
			System.out.println("Amount  Payable:"+proposer.getAmount());
		}
		session.close();
	}
////	/display records using native SQL/
//	public void DisplayRecords_NativeSQL() throws HibernateException {
//		Session session = factory.openSession();
//		String sql = "SELECT * FROM hibernate_create_insert_update_delete WHERE salary > 8000";
//		SQLQuery query = session.createSQLQuery(sql);
//		query.addEntity(Employee.class);
//		List results = query.list();
//		
//		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
//			Employee emp = (Employee) iterator.next();
//			System.out.println("First name :"+emp.getFirstName());
//			System.out.println("Last name :"+emp.getLastName());
//			System.out.println("Salary :"+emp.getSalary());
//		}
//		session.close();
//	}
//	/Update salary for an employee/
	public void UpdateRecord(Integer policyNo, Integer amount) throws HibernateException {
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Insurance ip = (Insurance) session.get(Insurance.class, policyNo);
		ip.setAmount(amount);
		session.update(ip);
		tx.commit();
		session.close();
	}
//	/Delete Records given employee ID/
	public void DeleteRecord(Integer policyNo) throws HibernateException {
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Insurance ip = (Insurance) session.get(Insurance.class, policyNo);
		session.delete(ip);
		tx.commit();
		session.close();
	}
	
	
}