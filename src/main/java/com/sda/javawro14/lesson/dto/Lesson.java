package com.sda.javawro14.lesson.dto;

import java.util.Date;

public class Lesson {
    private String theme;
    private Date date;

    public Lesson() {
    }

    public Lesson(String theme, Date date) {
        this.theme = theme;
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
