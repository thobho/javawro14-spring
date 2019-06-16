package com.sda.javawro14.lesson.repository;

import com.sda.javawro14.lesson.model.LessonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository extends MongoRepository<LessonDocument, String> {
}
