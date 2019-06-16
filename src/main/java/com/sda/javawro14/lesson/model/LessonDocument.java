package com.sda.javawro14.lesson.model;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class LessonDocument {

    @Id
    private String id; //getter i stetter
    private String theme;
    private Date date;

    public LessonDocument() {
    }

    public LessonDocument(String theme, Date date) {
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
