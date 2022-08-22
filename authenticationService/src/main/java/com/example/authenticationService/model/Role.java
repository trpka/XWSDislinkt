package com.example.authenticationService.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Document("roles")
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String name;

    public Role() {}
    public Role(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

