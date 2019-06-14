package com.sda.javawro14.user.repository;

import com.sda.javawro14.user.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity getById(String id);

    UserEntity getByName(String name);
}
