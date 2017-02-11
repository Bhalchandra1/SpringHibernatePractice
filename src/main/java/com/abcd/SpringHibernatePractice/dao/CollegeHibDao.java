package com.abcd.SpringHibernatePractice.dao;

import com.abcd.SpringHibernatePractice.model.College;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import java.util.List;
import java.util.Properties;

/**
 * Dao for College
 */
public class CollegeHibDao {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory createSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         return sessionFactory;
    }

    public void persistRecord(){
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        College c = new College();
        c.setCName("GIT");
        c.setcAddress("Lavel");

        session.save(c);

        session.flush();
        transaction.commit();

        List<College> clist = session.createQuery("from College").list();

        for (College c1: clist
             ) {
            System.out.println(c1.getCName());
        }

        session.close();
    }
}
