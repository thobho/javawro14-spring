package com.sda.javawro14.user.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    private String id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private static long idCounter = 0;

    public User(String name, Date dateOfBirth) {
        this.id = Long.toString(idCounter);
        idCounter++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
        this.id = Long.toString(idCounter);
        idCounter++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
