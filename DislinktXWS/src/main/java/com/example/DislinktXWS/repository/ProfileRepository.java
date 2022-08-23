package com.example.DislinktXWS.repository;

import com.example.DislinktXWS.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {
}
