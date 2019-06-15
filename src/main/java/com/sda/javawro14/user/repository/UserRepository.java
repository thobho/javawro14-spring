package com.sda.javawro14.user.repository;

import com.sda.javawro14.user.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
}
