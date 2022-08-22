package com.example.authenticationService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Document("users")
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String korisnicko;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String profilePicture;
    private boolean enabled;
    //private Timestamp lastPasswordResetDate;
    private List<Role> roles;
    private String roleType;
    public User() {}



    public User(Long id, String korisnicko, String password, String firstName, String lastName, String email,
                boolean enabled, List<Role> roles, String roleType) {
        super();
        this.id = id;
        this.korisnicko = korisnicko;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
        this.roleType = roleType;
    }




    public User(Long id, String korisnicko, String password, String firstName, String lastName, String email,
                String mobile, String profilePicture, boolean enabled, List<Role> roles, String roleType) {
        super();
        this.id = id;
        this.korisnicko = korisnicko;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.profilePicture = profilePicture;
        this.enabled = enabled;
        this.roles = roles;
        this.roleType = roleType;
    }



    public String getMobile() {
        return mobile;
    }



    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getProfilePicture() {
        return profilePicture;
    }



    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }



    public String getRoleType() {
        return roleType;
    }



    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return korisnicko;
    }

    public void setUsername(String username) {
        this.korisnicko = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //Timestamp now = new Timestamp(new Date().getTime());
        //this.setLastPasswordResetDate(now);
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /*public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
     */

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    public String getKorisnicko() {
        return korisnicko;
    }


    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }

}