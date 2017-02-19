package com.abcd.SpringHibernatePractice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Model class for College
 */
@Entity
@Table(name = "College")
public class College {

    @Column(name = "cid")
    private String cId = UUID.randomUUID().toString();
    @Column(name = "cname")
    private String cName;
    @Column(name = "caddress")
    private String cAddress;

    @Id
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }
}
