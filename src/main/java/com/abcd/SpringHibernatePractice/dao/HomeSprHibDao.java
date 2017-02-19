package com.abcd.SpringHibernatePractice.dao;

import com.abcd.SpringHibernatePractice.model.Home;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * DAo for Home model class
 */
@Repository
@Transactional
public class HomeSprHibDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void persistHome(Home home){
        hibernateTemplate.setCheckWriteOperations(false);
        hibernateTemplate.persist(home);
            }

    public List<Home> getAllHomes(){
        hibernateTemplate.setCheckWriteOperations(false);
       return (List)hibernateTemplate.find("from Home");
    }
}
