package com.example.DislinktXWS.DTO;

import com.example.DislinktXWS.model.Post;

public class NewLikeDTO {
    private Long idProfileWhoLike;
    private Post likedPost;

    public Long getIdProfileWhoLike() {
        return idProfileWhoLike;
    }

    public void setIdProfileWhoLike(Long idProfileWhoLike) {
        this.idProfileWhoLike = idProfileWhoLike;
    }

    public Post getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }
}
