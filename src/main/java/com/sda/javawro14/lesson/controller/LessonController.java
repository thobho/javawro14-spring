package com.sda.javawro14.lesson.controller;

import com.sda.javawro14.lesson.dto.LessonDto;
import com.sda.javawro14.lesson.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("allLessonsPage")
    public String getAllLessonsPage(Model model){
        model.addAttribute("allLessons", lessonService.getAllLessons());
        model.addAttribute("newLesson", new LessonDto());
        //todo czy to wszystkie atrybuty modelu???
        return "allLessonsPage";
    }

    @PostMapping("saveLessonAction")
    public String saveLessonAction(@ModelAttribute("newLesson") LessonDto newLesson,
                                   Model model){
        lessonService.saveLesson(newLesson);
        return "redirect:/allLessonsPage";
    }
}
