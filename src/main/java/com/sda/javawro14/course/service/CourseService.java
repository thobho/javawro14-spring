package com.sda.javawro14.course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javawro14.course.dto.Course;
import com.sda.javawro14.course.model.CourseDocument;
import com.sda.javawro14.course.repository.CourseRepositrory;
import com.sda.javawro14.lesson.dto.Lesson;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.lesson.repository.LessonRepository;
import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.model.UserEntity;
import com.sda.javawro14.user.repository.UserRepository;
import com.sda.javawro14.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseService {

    private UserService userService;

    private CourseRepositrory courseRepositrory;

    private UserRepository userRepository;

    private LessonRepository lessonRepository;

    private ModelMapper modelMapper;


    public CourseService(UserService userService, CourseRepositrory courseRepositrory, UserRepository userRepository,
                         LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.courseRepositrory = courseRepositrory;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    void init(){
        Course spring1 = new Course("SQL");

        CourseDocument spring = modelMapper.map(spring1, CourseDocument.class);

        List<UserEntity> allUsers = userRepository.findAll();
        List<LessonDocument> allLessonEntities = lessonRepository.findAll();

        spring.setUsers(allUsers);
        spring.setLessons(allLessonEntities);

        courseRepositrory.save(spring);
    }

    public void createNewCourse(String courseName, List<User> users, List<Lesson> lessons){

    }

    public List<Course> getAllCours(){
        List<CourseDocument> all = courseRepositrory.findAll();
        List<Course> collect = all.stream()
                .map(courseDocument -> modelMapper.map(courseDocument, Course.class))
                .collect(toList());
        return collect;
    }
}
