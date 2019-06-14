package com.sda.javawro14.lesson.service;

import com.sda.javawro14.lesson.model.Lesson;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {
    public List<Lesson> lessons = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.lessons.add(new Lesson("Spring", new Date()));
        this.lessons.add(new Lesson("Projekt grupowy", new Date()));
    }

    public List<Lesson> getAllLessons(){
        return this.lessons;
    }
}
