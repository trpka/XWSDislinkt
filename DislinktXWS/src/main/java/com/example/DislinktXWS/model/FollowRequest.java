package com.example.DislinktXWS.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "followRequests")
public class FollowRequest {
    @Id
    private Long id;
    private String username;
    private String usernameWhoWantToFollow;
    private boolean followRequest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameWhoWantToFollow() {
        return usernameWhoWantToFollow;
    }

    public void setUsernameWhoWantToFollow(String usernameWhoWantToFollow) {
        this.usernameWhoWantToFollow = usernameWhoWantToFollow;
    }

    public boolean isFollowRequest() {
        return followRequest;
    }

    public void setFollowRequest(boolean followRequest) {
        this.followRequest = followRequest;
    }

    public FollowRequest(Long id, String username, String usernameWhoWantToFollow, boolean followRequest) {
        this.id = id;
        this.username = username;
        this.usernameWhoWantToFollow = usernameWhoWantToFollow;
        this.followRequest = followRequest;
    }

    public FollowRequest(){
    }
}
