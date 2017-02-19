package com.abcd.SpringHibernatePractice.service;

import com.abcd.SpringHibernatePractice.dao.CollegeHibDao;
import com.abcd.SpringHibernatePractice.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Class for College
 */
@Service
public class CollegeService {

    @Autowired
    private CollegeHibDao collegeDao;

    @Transactional
    public String registerCollege() {
        String response = "Registration is successfully completed";
        // TODO:add service implementation
        return response;
    }
    @Transactional
    public String deRegisterCollege() {
        String response = "De-Registration is successfully completed";
        // TODO:add service implementation
        return response;
    }

    @Transactional
    public void updateCollege() {

    }

    public List<College> getColleges(){
        List<College> list = null;
        //TODO: ADD service Implementation
        return list;
    }

}
