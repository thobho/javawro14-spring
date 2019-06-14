package com.sda.javawro14.course.controller;

import com.sda.javawro14.course.dto.Course;
import com.sda.javawro14.course.service.CourseService;
import com.sda.javawro14.lesson.dto.Lesson;
import com.sda.javawro14.lesson.service.LessonService;
import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;

    private final UserService userService;

    private final LessonService lessonService;


    @Autowired
    public CourseController(CourseService courseService, UserService userService, LessonService lessonService) {
        this.courseService = courseService;
        this.userService = userService;
        this.lessonService = lessonService;
    }

    @GetMapping("/allCoursesPage")
    public String displayAllCourses(Model model) {
        List<Course> allCours = courseService.getAllCours();
        model.addAttribute("allCourses", allCours);
        return "allCoursesPage";
    }

    @GetMapping("/addNewCoursePage")
    public String addNewCoursePage(Model model) {
        model.addAttribute("allStudents", userService.getAllUsers());
        model.addAttribute("allLessons", lessonService.getAllLessons());
        model.addAttribute("newCourse", new NewCourseFormData());
        return "addNewCoursePage";
    }

    @PostMapping("/addNewCourseAction")
    public String addNewCourseAction(@ModelAttribute("newCourse") NewCourseFormData newCourse) {
        System.out.println(newCourse);
        return "redirect:/addNewCoursePage";
    }

    public static class NewCourseFormData {
        private String name;
        private String[] lessons;
        private String[] users;
        private String startDate;

        public NewCourseFormData() {
        }

        public NewCourseFormData(String name, String[] lessons, String[] users, String startDate) {
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
}
