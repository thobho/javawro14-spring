package com.sda.javawro14.course.dto;

public class NewCourseFormDateDTO {
    private String name;
    private String[] lessons;
    private String[] users;
    private String startDate;

    public NewCourseFormDateDTO() {
    }

    public NewCourseFormDateDTO(String name, String[] lessons, String[] users, String startDate) {
        this.name = name;
        this.lessons = lessons;
        this.users = users;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLessons() {
        return lessons;
    }

    public void setLessons(String[] lessons) {
        this.lessons = lessons;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
