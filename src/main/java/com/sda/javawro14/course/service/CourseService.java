package com.sda.javawro14.course.service;

import com.sda.javawro14.course.dto.CourseDto;
import com.sda.javawro14.course.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final ModelMapper modelMapper;

    private final CourseRepository courseRepository;

    public CourseService(ModelMapper modelMapper, CourseRepository courseRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    public String addNewCourse(){
        //todo co bedzie potrzebne do tworzenia kursu, jakie będą typy parametrów
        return "";
    }

    public List<CourseDto> getAllCourses(){
        return courseRepository.findAll().stream()
                .map(courseDocument -> modelMapper.map(courseDocument, CourseDto.class))
                .collect(Collectors.toList());
    }
}
