package com.example.authenticationService.repository;


import com.example.authenticationService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User,Long> {
    User findByKorisnicko(String username);
}
