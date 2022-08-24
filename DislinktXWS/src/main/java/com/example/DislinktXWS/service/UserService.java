package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.User;

import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //Izmena podataka  o Useru

    public User UpdateUser(User u)
    {
        User editUser = userRepository.getByUsername(u.getUsername());


        editUser.setFirstName(u.getFirstName());
        editUser.setLastName(u.getLastName());
        editUser.setUsername(u.getUsername());
        editUser.setPassword(u.getPassword());
        editUser.setEmail(u.getEmail());
        editUser.setDateOfBirth(u.getDateOfBirth());

        return  this.userRepository.save(editUser);

    }


    //ZZZ deo
   /* public ResponseEntity<User> updateUser(String username, @RequestBody User u)
    {

        User user = userRepository.getByUsername(username);
        System.out.println("prosledjeni user " + u.getUsername());
        System.out.println("pronadjeni user " + user.getUsername());
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setEmail(u.getEmail());
        user.setDateOfBirth(u.getDateOfBirth());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }*/






    public void delete(User user) {
        this.userRepository.delete(user);
    }


    public List<User> findAll() {
        return this.userRepository.findAll();
    }




}
