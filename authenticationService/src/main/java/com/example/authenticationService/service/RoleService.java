package com.example.authenticationService.service;


import java.util.List;
import com.example.authenticationService.model.Role;

public interface RoleService {
    Role findById(String id);
    List<Role> findByName(String name);
    Role save(Role role);
}
