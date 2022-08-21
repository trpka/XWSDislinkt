package com.example.DislinktXWS.repository;
import com.example.DislinktXWS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import  com.example.DislinktXWS.model.User;

import java.util.ArrayList;
import  java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long>
{
    User getByUsername(String username);

    User getByFirstName(String firstName);

    //public List<User> getUsersByPartOfUsername(String part_of_username);
    public ArrayList<User> getUsersByUsername(String username);




}
