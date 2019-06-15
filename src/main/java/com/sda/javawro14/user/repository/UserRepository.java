package com.sda.javawro14.user.repository;

import com.sda.javawro14.user.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    List<UserDocument> findByNameLikeOrderByNameAsc(String queryString);



}
