package com.example.DislinktXWS.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "comments")
public class Comment {
    @Id
    private Long id;
    private String userId;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(Long id, String userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }
    public Comment(String userId, String content) {

        this.userId = userId;
        this.content = content;
    }

    public Comment() {
    }
}
