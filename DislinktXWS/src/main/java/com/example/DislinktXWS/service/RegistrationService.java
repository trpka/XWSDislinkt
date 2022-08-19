package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
       return   this.userRepository.save(user);
    }


}
