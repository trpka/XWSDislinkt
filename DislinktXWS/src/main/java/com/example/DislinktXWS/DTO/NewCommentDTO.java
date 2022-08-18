package com.example.DislinktXWS.DTO;

import com.example.DislinktXWS.model.Comment;
import com.example.DislinktXWS.model.Post;

public class NewCommentDTO {

    private Post post;
    private Comment comment;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public NewCommentDTO(Post post, Comment comment) {
        this.post = post;
        this.comment = comment;
    }
    public NewCommentDTO() {

    }


}
