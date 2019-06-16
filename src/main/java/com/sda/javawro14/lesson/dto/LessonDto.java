package com.sda.javawro14.lesson.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LessonDto {

    private String id;
    private String theme;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    public LessonDto() {
    }

    public LessonDto(String theme, Date date) {
        this.theme = theme;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
