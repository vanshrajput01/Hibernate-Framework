package com.temp.Hibernate_Project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
         // Save student object (means add data in student table).
        SessionFactory factory = new Configuration().configure("pass here url of hibernate configuration file.").buildSessionFactory();
        Session session = factory.openSession();
        Student st = new Student();
        st.setStudName("student03");
        st.setStudFee(15000);
        Transaction trx = session.beginTransaction();
        session.save(st);
        trx.commit();
        System.out.println("data add successFully!!");
        session.close();
        
        // if you want to get data in Table by using id..

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	// if you can get data by id..
    	Student st = session.get(Student.class, 1);
        // you can also use load method in place of get method...
    	System.out.println("Stuednt deatils is :-" + st.getStudName() + " " + st.getStudFee());
    	session.close();

        // if you want to update data in Table by 
            	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	EmployeeEntity emp = session.load(EmployeeEntity.class, 2);
//    	emp.setEmpId(1);
    	emp.setEmpName("employee02");
    	emp.setEmpSalary(11500);
    	session.update(emp);
    	System.out.println("student update!!");
    	transaction.commit();
//    	System.out.println("employee details is :-" + emp.getEmpId() +  " " + emp.getEmpName());
    	session.close();

        //if you want to delete data in table

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	EmployeeEntity emp = session.load(EmployeeEntity.class, 3);
    	session.delete(emp);
    	transaction.commit();
    	System.out.println("data deleted");


        
        
    }
}
