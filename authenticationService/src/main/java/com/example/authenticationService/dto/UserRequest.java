package com.example.authenticationService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//DTO koji preuzima podatke sa forme za registraciju
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;

    private String korisnicko;

    private String password;

    private String firstname;

    private String lastname;

    private String email;

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String username) {
        this.korisnicko = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

