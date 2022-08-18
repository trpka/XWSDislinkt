import { Comment } from "./comment.model";
import { Post } from "./post.model";

interface NewCommentInterface{
    comment:Comment;
    post:Post;
    
}
export class NewComment implements NewCommentInterface{
    comment:Comment;
    post:Post;
    constructor(obj:NewCommentInterface){
        this.comment=obj.comment;
        this.post=obj.post;
    } 
}