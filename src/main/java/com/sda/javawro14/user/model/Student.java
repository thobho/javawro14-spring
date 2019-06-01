package com.sda.javawro14.user.model;

import java.util.Date;

public class Student extends User{

    private String studentCardNumber;

    public Student(String name, Date dateOfBirth, String studentCardNumber) {
        super(name, dateOfBirth);
        this.studentCardNumber = studentCardNumber;
    }
}
