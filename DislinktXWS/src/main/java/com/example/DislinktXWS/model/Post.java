package com.example.DislinktXWS.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String ownerId;
    private String text;
    private List<String> likes;
    private List<String> dislikes;
    private List<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<String> dislikes) {
        this.dislikes = dislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(String id, String ownerId, String text, List<String> likes, List<String> dislikes, List<Comment> comments) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    public Post() {
    }
}
