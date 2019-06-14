package com.sda.javawro14.course.service;

import com.sda.javawro14.course.model.Course;
import com.sda.javawro14.lesson.model.Lesson;
import com.sda.javawro14.lesson.service.LessonService;
import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    private UserService userService;

    private LessonService lessonService;

    private List<Course> allCourses = new ArrayList<>();

    @PostConstruct
    void init(){
        Course spring = new Course("Spring");
        Lesson lessonIntro = new Lesson("Intro", new Date());
        Lesson lessonSpringBoot = new Lesson("SpringBoot", new Date());
        spring.setLessons(Arrays.asList(lessonIntro, lessonSpringBoot));
        spring.setUsers(Arrays.asList(new User("Janusz", new Date()), new User("Danuta", new Date())));

        allCourses.add(spring);
    }

    @Autowired
    public CourseService(UserService userService, LessonService lessonService) {
        this.userService = userService;
        this.lessonService = lessonService;
    }

    public void createNewCourse(String courseName, List<User> users){
        Course course = new Course(courseName);
        course.setUsers(users);
        course.setLessons(lessonService.getAllLessons());
        this.allCourses.add(course);
    }

    public List<Course> getAllCourses(){
        return this.allCourses;
    }
}
