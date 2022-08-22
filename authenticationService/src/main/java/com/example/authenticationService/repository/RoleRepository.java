package com.example.authenticationService.repository;

import com.example.authenticationService.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role,String> {

    List<Role> findByName(String name);
}
