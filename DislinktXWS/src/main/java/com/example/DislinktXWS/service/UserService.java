package com.example.DislinktXWS.service;

import
        com.example.DislinktXWS.model.User;

import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User save(User user){
        return this.userRepository.save(user);
    }

    public User findById(Long id)
    {
        Optional<User> opt=this.userRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    //Pronalazenje Korisnika po Delu Korisnickog imena
    public List<User> searchByPartUsername(String part_username)
    {
        List<User> all_users = userRepository.findAll();

       ArrayList<User> searched_users = new ArrayList<User>();

       for(User u: all_users)
       {
           if(u.getUsername().toLowerCase().contains(part_username.toLowerCase()))
           {
               searched_users.add(u);
           }
       }
       return searched_users;
    }


    //Pronalazenje Korisnika po korisnickom imenu ****** novo
    public User getByUsername(String username)
    {
        User user = userRepository.getByUsername(username);
        return  user;
    }



    public void delete(User user) {
        this.userRepository.delete(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }


}
