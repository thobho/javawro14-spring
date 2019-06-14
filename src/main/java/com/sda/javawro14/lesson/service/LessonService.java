package com.sda.javawro14.lesson.service;

import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.lesson.repository.LessonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {
    public List<LessonDocument> lessonEntities = new ArrayList<>();

    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @PostConstruct
    public void init() {
        long count = lessonRepository.count();

        if (count < 3) {
            lessonRepository.save(new LessonDocument("Sql", new Date()));
            lessonRepository.save(new LessonDocument("Spring", new Date()));
            lessonRepository.save(new LessonDocument("Projekt grupowy", new Date()));
        }

    }

    public List<LessonDocument> getAllLessons() {
        return this.lessonEntities;
    }
}
