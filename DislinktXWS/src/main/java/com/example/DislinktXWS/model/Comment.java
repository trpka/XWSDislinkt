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
    private Long userId;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment(Long id, Long userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }
    public Comment(Long userId, String content) {

        this.userId = userId;
        this.content = content;
    }

    public Comment() {
    }
}
