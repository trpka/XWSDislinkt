interface FollowRequestInterface{
    id?:number;
    username:string;
    usernameWhoWantToFollow:string;
    followRequest:boolean;
}
export class FollowRequest implements FollowRequestInterface{
    id?: number ;
    username:string;
    usernameWhoWantToFollow:string;
    followRequest:boolean;

    constructor(obj:FollowRequestInterface){
        this.id=obj.id;
        this.username=obj.username;
        this.usernameWhoWantToFollow=obj.usernameWhoWantToFollow;
        this.followRequest=obj.followRequest;
    } 
}