package com.sda.javawro14.course.controller;

import com.sda.javawro14.course.dto.NewCourseFormDateDTO;
import com.sda.javawro14.course.service.CourseService;
import com.sda.javawro14.lesson.service.LessonService;
import com.sda.javawro14.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;

@Controller
public class CourseController {

    private final CourseService courseService;

    private final UserService userService;

    private final LessonService lessonService;

    public CourseController(CourseService courseService, UserService userService, LessonService lessonService) {
        this.courseService = courseService;
        this.userService = userService;
        this.lessonService = lessonService;
    }

    @GetMapping("courseFormPage")
    public String getCourseFormPage(Model model){
        model.addAttribute("allStudents", userService.getAllUsers());
        model.addAttribute("allLessons", lessonService.getAllLessons());
        model.addAttribute("newCourse", new NewCourseFormDateDTO());
        return "courseFormPage";
    }

    @PostMapping("addNewCourse")
    public String addNewCourse(@ModelAttribute("newCourse") NewCourseFormDateDTO newCourseFormDateDTO) throws ParseException {

        courseService.addNewCourse(newCourseFormDateDTO);



        return "allUsersPage";
    }
}
