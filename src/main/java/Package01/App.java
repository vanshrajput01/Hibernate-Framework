package com.temp.Hibernate_Project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
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
        
    }
}
