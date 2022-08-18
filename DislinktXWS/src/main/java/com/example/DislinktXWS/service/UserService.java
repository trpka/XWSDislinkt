package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return this.userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> opt=this.userRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
