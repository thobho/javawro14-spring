package com.sda.javawro14.lesson.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "lesson")
public class LessonDocument {

    private String id;
    private String theme;
    private Date date;

    public LessonDocument(String theme, Date date) {
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
