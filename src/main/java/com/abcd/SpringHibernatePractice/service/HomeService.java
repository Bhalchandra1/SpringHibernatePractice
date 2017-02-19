package com.abcd.SpringHibernatePractice.service;

import com.abcd.SpringHibernatePractice.dao.HomeSprHibDao;
import com.abcd.SpringHibernatePractice.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Class for Home
 */
@Service
public class HomeService {
    @Autowired
    private HomeSprHibDao dao;

    @Transactional
    public void insertHome(){
        dao.persistHome(new Home("ECITY"));
    }
}

