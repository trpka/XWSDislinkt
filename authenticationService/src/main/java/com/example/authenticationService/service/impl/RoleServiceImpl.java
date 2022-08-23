package com.example.authenticationService.service.impl;


import com.example.authenticationService.model.Role;
import com.example.authenticationService.repository.RoleRepository;
import com.example.authenticationService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(String id) {
        Role auth = this.roleRepository.findById(id).get();
        return auth;
    }

    @Override
    public List<Role> findByName(String name) {
        List<Role> roles = this.roleRepository.findByName(name);
        return roles;
    }

    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }
}


