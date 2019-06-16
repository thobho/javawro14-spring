package com.sda.javawro14.course.dto;

import com.sda.javawro14.lesson.dto.LessonDto;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.user.model.UserDTO;
import com.sda.javawro14.user.model.UserDocument;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CourseDto {
    private String id;
    private String name;
    private List<LessonDto> lessons;
    private List<UserDTO> users;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public CourseDto() {
    }

    public CourseDto(String id, String name, List<LessonDto> lessons, List<UserDTO> users, Date startDate) {
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

    public List<LessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDto> lessons) {
        this.lessons = lessons;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
