package com.sda.javawro14.course.model;

import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.user.model.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "course")
public class CourseDocument {

    @Id
    private String id;
    private String name;
    private List<LessonDocument> lessons;
    private List<UserEntity> users;
    private Date startDate;
    private Date endDate;

    public CourseDocument() {

    }

    public CourseDocument(String id, String name, List<LessonDocument> lessonEntities, List<UserEntity> users, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.lessons = lessonEntities;
        this.users = users;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LessonDocument> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDocument> lessons) {
        this.lessons = lessons;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
