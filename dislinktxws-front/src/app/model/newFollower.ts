interface NewFolloweInterface{
    idProfileUser : number;
    idFollowerUser : number;
    
}
export class NewFollower implements NewFolloweInterface{
    idProfileUser : number;
    idFollowerUser : number;
    constructor(obj:NewFolloweInterface){
        this.idProfileUser=obj.idProfileUser;
        this.idFollowerUser=obj.idFollowerUser;
    } 
}