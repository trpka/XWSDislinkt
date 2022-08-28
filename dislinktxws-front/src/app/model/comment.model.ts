interface CommentInterface{
    id?:number;
    userId:number;
    content:string;
}
export class Comment implements CommentInterface{
    id?: number | undefined;
    userId:number;
    content:string;
    constructor(obj:CommentInterface){
        this.id=obj.id;
        this.userId=obj.userId;
        this.content=obj.content;
    } 
}