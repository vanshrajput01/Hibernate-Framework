package com.hibernateFramework.Project01;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {


######################################################## How to insert data from table using native ####################
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//    	How to get single data from table using HQL langauge
		Transaction transaction = session.beginTransaction();
		String q = "insert into employee_details(emp_id,emp_name,emp_salary)values(?,?,?)";
		Query query = session.createSQLQuery(q);
		query.setParameter(1, 6);
		query.setParameter(2, "emp06");
		query.setParameter(3, 26300);
		query.executeUpdate();
		System.out.println("data Inserted!!");
		transaction.commit();
		session.close();

######################################################## How to get all data from table using native ####################

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		String q = "select * from employee_details";
		Query query = session.createSQLQuery(q);
		List<Object[]> empList = query.getResultList();
		for(Object[] obj : empList) {
			System.out.println(obj[0].toString()  + " " + obj[1].toString() + " " + obj[2].toString());
			
		}


		session.close();

	}



#################################################  How to get data from table using native Query #####################################################

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//    	How to get single data from table using HQL langauge
		String q = "select * from employee_details where emp_id = :id";
		Query query = session.createSQLQuery(q);
		query.setParameter("id", 2);
		Object[] empobj = (Object[]) query.uniqueResult();
		System.out.println("employee details :- " + empobj[0].toString() + " " + empobj[1].toString());
		session.close();

}

###################################################  How to update data from native Query ############################################################

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String q = "update employee_details set emp_name = ?,emp_salary = ? where emp_id = ?";
		Query query = session.createSQLQuery(q);
		query.setParameter(1, "employee05");
		query.setParameter(2, 13400);
		query.setParameter(3, 5);
		query.executeUpdate();
		System.out.println("data updated!!");
		transaction.commit();
		session.close();



###################################################### How to delete data in table using native query ##########################################################

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String q = "delete from employee_details where emp_id = ?";
		Query query = session.createSQLQuery(q);
		query.setParameter(1, 1);
		query.executeUpdate();
		System.out.println("data deleted!!");
		transaction.commit();
		session.close();



