package com.hibernateFramework.Project01;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateFramework.Entity.EmployeeEntity;
public class App 
{
    public static void main( String[] args )
    {
        ##################################################   How to get single row in database using HQL language #################################################### 
            
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	String q = "from EmployeeEntity where empId = :id";
    	Query query = session.createQuery(q);
    	query.setParameter("id", 2);
    	EmployeeEntity emp = (EmployeeEntity)query.uniqueResult();
    	System.out.println("Employee details :- "+ emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getEmpSalary());
    	session.close();

        #############################################  How to get all data in database using List method ###################################################
            
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	String q = "from EmployeeEntity";
    	Query query = session.createQuery(q);
    	List<EmployeeEntity> empList = query.list();
    	for (EmployeeEntity emp : empList) {
    		System.out.println(" **** employee details *****");
    		System.out.println("emp id" + emp.getEmpId() + "data is :- " + emp.getEmpSalary() + " " +  emp.getEmpId());
    	}
     
         session.close();
    	############################################ How to get all data in database using Load method ######################################################

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
//    	How to get all data in database using HQL language. 
    	String q = "from EmployeeEntity";
    	Query query = session.createQuery(q);
    	List<EmployeeEntity> empList = query.getResultList();
    	for (EmployeeEntity emp : empList) {
    		System.out.println(" **** employee details *****");  
    		System.out.println("emp id" + emp.getEmpId() + "data is :- " + emp.getEmpSalary() + " " +  emp.getEmpId());
    	}
    	

    	session.close();

        #################################################  How to update data form Table ################################################################
            
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();=
    	Transaction transaction = session.beginTransaction();
    	String q = "update from EmployeeEntity set empName = :name , empSalary = :salary where empId = :id";
    	Query query = session.createQuery(q);
    	query.setParameter("name", "emp02");
    	query.setParameter("salary", 12050);
    	query.setParameter("id", 2);
    	
    	query.executeUpdate();
    	System.out.println("Update data!!");

    	transaction.commit();
    	

    	session.close();

      
    		
    		
    	}


    #########################################################  How to delete data from table using hibernate ##############################################

    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//    	How to update data from table using HQL langauge
		Transaction transaction = session.beginTransaction();
		String q = "delete from EmployeeEntity where empId = :id";
		Query query = session.createQuery(q);
		query.setParameter("id", 4);
		query.executeUpdate();
		System.out.println("data delete!!");
		transaction.commit();
        session.close();
    	

       
        
    
}
