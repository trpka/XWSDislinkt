import { Post } from "./post.model";

interface NewDislikeDTOInterface{
    idProfileWhoDislike : number;
    dislikedPost : Post;
    
}
export class NewDislikeDTO implements NewDislikeDTOInterface{
    idProfileWhoDislike : number;
    dislikedPost : Post;
    constructor(obj:NewDislikeDTOInterface){
        this.idProfileWhoDislike=obj.idProfileWhoDislike;
        this.dislikedPost=obj.dislikedPost;
    } 
}