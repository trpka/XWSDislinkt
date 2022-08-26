package com.example.DislinktXWS.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter

@Document(collection = "profiles")
public class Profile {
    private Long id;
    private User user;
    private List<String> experience;
    private List<String> education;
    private List<String> interests;
    private List<String> skills;
    private boolean privateProfile;
    //private List<Post> posts;
    private List<Long> followers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Long> followers) {
        this.followers = followers;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    /*public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }*/

    public boolean isPrivateProfile() {
        return privateProfile;
    }

    public void setPrivateProfile(boolean privateProfile) {
        this.privateProfile = privateProfile;
    }

    public Profile(User user, List<String> experience, List<String> education, List<String> interests, List<String> skills, boolean privateProfile, List<Long> followers) {
        this.user = user;
        this.experience = experience;
        this.education = education;
        this.interests = interests;
        this.skills = skills;
        this.privateProfile = privateProfile;
        this.followers = followers;
    }

    public Profile()
    {

    }
}
