package com.example.DislinktXWS.repository;

import com.example.DislinktXWS.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import  com.example.DislinktXWS.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
