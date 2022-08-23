import { Comment } from "./comment.model";

interface PostInterface{
    id?:number;
    ownerId:number;
    text:string;
    userIdWhoLikes:number[];
    userIdWhoDislikes:number[];
    comments:Comment[];
}
export class Post implements PostInterface{
    id?:number;
    ownerId:number;
    text:string;
    userIdWhoLikes:number[];
    userIdWhoDislikes:number[];
    comments:Comment[];
    constructor(obj:PostInterface){
        this.id=obj.id;
        this.ownerId=obj.ownerId;
        this.text=obj.text;
        this.userIdWhoLikes=obj.userIdWhoLikes;
        this.userIdWhoDislikes=obj.userIdWhoDislikes;
        this.comments=obj.comments;
    } 
}