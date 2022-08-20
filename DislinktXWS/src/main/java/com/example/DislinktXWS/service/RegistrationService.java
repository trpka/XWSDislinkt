package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService
{
    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username)
    {
        User user = userRepository.getByUsername(username);
        return  user;
    }

    public User registration(User user)
    {
        List<User> listOfAll = this.userRepository.findAll();

        if(userRepository.getByUsername(user.getUsername()) != null)
        {
            System.out.println("Username Already exists! ");
            return null;
        }

        //Automatsko prosledjivanje novog ID-ja
        Long id = (long)0;
        for(User u: listOfAll)
        {
            id = u.getId();
        }
        id = id + 1;
        user.setId(id);

        return   this.userRepository.save(user);
    }


    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }



}
