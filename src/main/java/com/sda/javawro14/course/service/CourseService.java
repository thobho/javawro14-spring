package com.sda.javawro14.course.service;

import com.sda.javawro14.course.dto.CourseDto;
import com.sda.javawro14.course.dto.NewCourseFormDateDTO;
import com.sda.javawro14.course.model.CourseDocument;
import com.sda.javawro14.course.repository.CourseRepository;
import com.sda.javawro14.lesson.model.LessonDocument;
import com.sda.javawro14.lesson.repository.LessonRepository;
import com.sda.javawro14.user.model.UserDocument;
import com.sda.javawro14.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final ModelMapper modelMapper;

    private final CourseRepository courseRepository;

    private final LessonRepository lessonRepository;

    private final UserRepository userRepository;

    public CourseService(ModelMapper modelMapper, CourseRepository courseRepository, LessonRepository lessonRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.userRepository = userRepository;
    }

    public String addNewCourse(NewCourseFormDateDTO formData) throws ParseException {
        //todo co bedzie potrzebne do tworzenia kursu, jakie będą typy parametrów

        List<String> lessonsIds = Arrays.asList(formData.getLessons());
        List<String> userIds = Arrays.asList(formData.getUsers());

        List<LessonDocument> lessonsToSave = lessonRepository.findAll()
                .stream()
                .filter(lessonDocument -> lessonsIds.contains(lessonDocument.getId()))
                .collect(Collectors.toList());

        List<UserDocument> usersToSave = userRepository.findAll()
                .stream()
                .filter(userDocument -> userIds.contains(userDocument.getId()))
                .collect(Collectors.toList());

        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(formData.getStartDate());

        CourseDocument courseDocument = new CourseDocument(
                null,
                formData.getName(),
                lessonsToSave,
                usersToSave,
                parse
        );

        return courseRepository.save(courseDocument).getId();
    }

    public List<CourseDto> getAllCourses(){
        return courseRepository.findAll().stream()
                .map(courseDocument -> modelMapper.map(courseDocument, CourseDto.class))
                .collect(Collectors.toList());
    }
}
