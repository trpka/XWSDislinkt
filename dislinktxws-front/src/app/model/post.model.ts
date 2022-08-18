import { Comment } from "./comment.model";

interface PostInterface{
    id?:number;
    ownerId:string;
    text:string;
    likes:number[];
    dislikes:number[];
    comments:Comment[];
}
export class Post implements PostInterface{
    id?:number;
    ownerId:string;
    text:string;
    likes:number[];
    dislikes:number[];
    comments:Comment[];
    constructor(obj:PostInterface){
        this.id=obj.id;
        this.ownerId=obj.ownerId;
        this.text=obj.text;
        this.likes=obj.likes;
        this.dislikes=obj.dislikes;
        this.comments=obj.comments;
    } 
}