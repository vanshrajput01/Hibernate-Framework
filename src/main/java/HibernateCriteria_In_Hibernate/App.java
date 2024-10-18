package com.hibernateFramework.Project01;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateFramework.Entity.EmployeeEntity;

public class App {
	public static void main(String[] args) {
    ############################################################  How to get All data in table using hibernate Criteria ###############################################

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(EmployeeEntity.class);
		List<EmployeeEntity> empList = criteria.list();
		for (EmployeeEntity emp :  empList) {
			System.out.println("Employees details is :-" + emp.getEmpId() + " " + emp.getEmpSalary());
			
		}
		session.close();


    ########################################################### get data in table using hibernate Criteria ##############################################
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(EmployeeEntity.class);
		criteria.add(Restrictions.idEq(2));
		EmployeeEntity emp = (EmployeeEntity) criteria.uniqueResult();
		System.out.println("employee details is :-" + emp.getEmpName() + " " + emp.getEmpSalary());

		session.close();

    ################################################################  OR ##################################################################

    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(EmployeeEntity.class);
		criteria.add(Restrictions.eq("empName","emp03"));
		EmployeeEntity emp = (EmployeeEntity) criteria.uniqueResult();
		System.out.println("employee details is :-" + emp.getEmpName() + " " + emp.getEmpSalary());

		session.close();
  

		


	}

}
