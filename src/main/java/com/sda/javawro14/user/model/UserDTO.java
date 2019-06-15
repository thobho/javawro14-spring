package com.sda.javawro14.user.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDTO {

    private String id;
    private String name;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    public UserDTO() {
    }

    public UserDTO(String id, String name, String password, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
