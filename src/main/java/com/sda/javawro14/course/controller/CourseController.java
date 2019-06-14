package com.sda.javawro14.course.controller;

import com.sda.javawro14.course.dto.Course;
import com.sda.javawro14.course.model.CourseDocument;
import com.sda.javawro14.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/allCoursesPage")
    public String displayAllCourses(Model model) {
        List<Course> allCours = courseService.getAllCours();
        model.addAttribute("allCourses", allCours);
        return "allCoursesPage";
    }
}
