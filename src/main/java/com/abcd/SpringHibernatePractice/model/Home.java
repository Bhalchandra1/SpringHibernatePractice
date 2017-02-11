package com.abcd.SpringHibernatePractice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by bhalchandra on 11/7/2016.
 */
@Entity
@Table (name = "Home")
public class Home {
    @Column(name = "homeNumber")
    private String homeNumber = UUID.randomUUID().toString();
    @Column(name = "homeAddress")
    private String homeAddress;

    public Home() {
    }

    public Home(String homeAddress) {
        super();
        this.homeAddress = homeAddress;
    }

    @Id
    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
