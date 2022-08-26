package com.example.DislinktXWS.repository;

import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {
    Profile findByUserUsername(String username);
    Profile findProfileById(Long id);
    Profile getById(Long id);
}