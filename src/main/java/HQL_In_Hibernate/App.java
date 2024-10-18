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
        //  How to get single row in database using HQL language. 
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	String q = "from EmployeeEntity where empId = :id";
    	Query query = session.createQuery(q);
    	query.setParameter("id", 2);
    	EmployeeEntity emp = (EmployeeEntity)query.uniqueResult();
    	System.out.println("Employee details :- "+ emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getEmpSalary());
    	session.close();

        //  How to get all data in database using HQL language. 
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

      
    		
    		
    	}
    	

       
        
    
}
