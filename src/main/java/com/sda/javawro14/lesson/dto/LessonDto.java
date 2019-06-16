package com.sda.javawro14.lesson.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LessonDto {

    //todo czy będzie potrzebny ID???
    private String theme;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    public LessonDto() {
    }

    public LessonDto(String theme, Date date) {
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
