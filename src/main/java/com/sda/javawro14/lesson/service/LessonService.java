package com.sda.javawro14.lesson.service;

import com.sda.javawro14.lesson.dto.Lesson;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.lesson.repository.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    private ModelMapper modelMapper;

    public LessonService(LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
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

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lessonDocument -> modelMapper.map(lessonDocument, Lesson.class)).collect(Collectors.toList());
    }
}
