import { Post } from "./post.model";

interface NewLikeInterface{
    idProfileWhoLike : number;
    likedPost : Post;
    
}
export class NewLike implements NewLikeInterface{
    idProfileWhoLike : number;
    likedPost : Post;
    constructor(obj:NewLikeInterface){
        this.idProfileWhoLike=obj.idProfileWhoLike;
        this.likedPost=obj.likedPost;
    } 
}