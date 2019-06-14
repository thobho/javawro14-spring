package com.sda.javawro14.course.dto;

import com.sda.javawro14.lesson.dto.Lesson;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.model.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
    private String name;
    private List<Lesson> lessons;
    private List<User> users;
    private Date startDate;
    private Date endDate;

    public Course(String name) {
        this.name = name;
        this.startDate = new Date();

        LocalDate endCourseDate = LocalDate.now()
                .plusMonths(7);

        this.endDate = java.sql.Date.valueOf(endCourseDate);
        this.lessons = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
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
