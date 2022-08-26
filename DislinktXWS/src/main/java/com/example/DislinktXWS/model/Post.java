package com.example.DislinktXWS.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Document(collection = "posts")
public class Post {
    @Id
    private Long id;
    private Long ownerId;
    private String text;
    private List<Long> userIdWhoLikes;
    private List<Long> userIdWhoDislikes;
    private List<Comment> comments;
    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> userIdWhoLikes() {
        return userIdWhoLikes;
    }

    public void userIdWhoLikes(List<Long> userIdWhoLikes) {
        this.userIdWhoLikes = userIdWhoLikes;
    }

    public List<Long> getUserIdWhoDislikes() {
        return userIdWhoDislikes;
    }

    public void setUserIdWhoDislikes(List<Long> userIdWhoDislikes) {
        this.userIdWhoDislikes = userIdWhoDislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Post(Long id, Long ownerId, String text, List<Long> userIdWhoLikes, List<Long> userIdWhoDislikes, List<Comment> comments, String picture) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWhoLikes = userIdWhoLikes;
        this.userIdWhoDislikes = userIdWhoDislikes;
        this.comments = comments;
        this.picture = picture;
    }

    public Post(Long id, Long ownerId, String text, List<Long> userIdWhoLikes, List<Long> userIdWhoDislikes, List<Comment> comments) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWhoLikes = userIdWhoLikes;
        this.userIdWhoDislikes = userIdWhoDislikes;
        this.comments = comments;
    }

    public Post(Long ownerId, String text, List<Long> userIdWhoLikes, List<Long> userIdWhoDislikes, List<Comment> comments) {
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWhoLikes = userIdWhoLikes;
        this.userIdWhoDislikes = userIdWhoDislikes;
        this.comments = comments;
    }

    public Post(Long ownerId, String text) {
        this.ownerId = ownerId;
        this.text = text;
        this.userIdWhoLikes = new ArrayList<>();
        this.userIdWhoDislikes = new ArrayList<>();
        this.comments =new ArrayList<>();
    }

    public Post() {
    }
}
