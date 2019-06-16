package com.sda.javawro14.lesson.service;

import com.sda.javawro14.lesson.dto.LessonDto;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.lesson.repository.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public LessonService(LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    public List<LessonDto> getAllLessons(){
        return lessonRepository.findAll()
                .stream()
                .map(lessonDocument -> modelMapper.map(lessonDocument, LessonDto.class))
                .collect(Collectors.toList());
    }

    public String saveLesson(LessonDto lessonDto){
        LessonDocument lessonToSave = modelMapper.map(lessonDto, LessonDocument.class);
        LessonDocument savedLesson = lessonRepository.save(lessonToSave);
        return savedLesson.getId();
    }
}
