package com.sda.javawro14.course.repository;

import com.sda.javawro14.course.model.CourseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepositrory extends MongoRepository<CourseDocument, String> {
}
