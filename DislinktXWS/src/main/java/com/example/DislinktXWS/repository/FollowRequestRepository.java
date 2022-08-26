package com.example.DislinktXWS.repository;


import com.example.DislinktXWS.model.FollowRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRequestRepository extends MongoRepository<FollowRequest, Long> {
}
