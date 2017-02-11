package com.abcd.SpringHibernatePractice.dao;

import com.abcd.SpringHibernatePractice.model.Home;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;


/**
 * Created by bhalchandra on 11/7/2016.
 */
public class HomeSprHibDao {
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory){
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void persistHome(Home home){
        hibernateTemplate.setCheckWriteOperations(false);
        hibernateTemplate.saveOrUpdate(home);
        hibernateTemplate.persist(home);
        System.out.println(home.getHomeNumber());
       //System.out.println("Persisted"+ hibernateTemplate.find("from Home where homeNumber = ?",home.getHomeNumber()));

    }
}
