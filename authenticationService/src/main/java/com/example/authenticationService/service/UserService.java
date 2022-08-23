package com.example.authenticationService.service;




import java.util.List;

import com.example.authenticationService.dto.UserRequest;
import com.example.authenticationService.model.User;

public interface UserService {
    User findById(Long id);
    User findByKorisnicko(String korisnicko);
    List<User> findAll ();
    User save(UserRequest    userRequest);
    User saveUser(User user);
}
