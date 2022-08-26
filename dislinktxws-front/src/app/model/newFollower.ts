interface NewFollowerInterface{
    idProfileUser : number;
    idFollowerUser : number;
    
}
export class NewFollower implements NewFollowerInterface{
    idProfileUser : number;
    idFollowerUser : number;
    constructor(obj:NewFollowerInterface){
        this.idProfileUser=obj.idProfileUser;
        this.idFollowerUser=obj.idFollowerUser;
    } 
}