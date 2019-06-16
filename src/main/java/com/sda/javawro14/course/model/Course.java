package com.sda.javawro14.course.model;

import com.sda.javawro14.lesson.dto.LessonDto;
import com.sda.javawro14.user.model.UserDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {

    private String name;
    private List<LessonDto> lessonDtos;
    private List<UserDTO> userDTOS;
    private Date startDate;
    private Date endDate;

    public Course(String name) {
        this.name = name;
        this.startDate = new Date();

        LocalDate endCourseDate = LocalDate.now()
                .plusMonths(7);

        this.endDate = java.sql.Date.valueOf(endCourseDate);
        this.lessonDtos = new ArrayList<>();
        this.userDTOS = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LessonDto> getLessonDtos() {
        return lessonDtos;
    }

    public void setLessonDtos(List<LessonDto> lessonDtos) {
        this.lessonDtos = lessonDtos;
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
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
