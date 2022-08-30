package com.example.DislinktXWS.DTO;

import com.example.DislinktXWS.model.Post;

public class NewDislikeDTO {
    private Long idProfileWhoDislike;
    private Post dislikedPost;

    public Long getIdProfileWhoDislike() {
        return idProfileWhoDislike;
    }

    public void setIdProfileWhoDislike(Long idProfileWhoDislike) {
        this.idProfileWhoDislike = idProfileWhoDislike;
    }

    public Post getDislikedPost() {
        return dislikedPost;
    }

    public void setDislikedPost(Post dislikedPost) {
        this.dislikedPost = dislikedPost;
    }
}
