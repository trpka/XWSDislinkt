package com.example.DislinktXWS.repository;

import com.example.DislinktXWS.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, Long> {

}
