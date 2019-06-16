package com.sda.javawro14.course.model;

import com.sda.javawro14.lesson.dto.LessonDto;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.user.model.UserDTO;
import com.sda.javawro14.user.model.UserDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class CourseDocument {

    @Id
    private String id;
    private String name;
    private List<LessonDocument> lessons;
    private List<UserDocument> users;
    private Date startDate;

    public CourseDocument() {
    }

    public CourseDocument(String id, String name, List<LessonDocument> lessons, List<UserDocument> users, Date startDate) {
        this.id = id;
        this.name = name;
        this.lessons = lessons;
        this.users = users;
        this.startDate = startDate;
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

    public List<LessonDocument> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDocument> lessons) {
        this.lessons = lessons;
    }

    public List<UserDocument> getUsers() {
        return users;
    }

    public void setUsers(List<UserDocument> users) {
        this.users = users;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
