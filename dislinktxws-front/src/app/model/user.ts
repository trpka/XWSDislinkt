import { Comment } from "./comment.model";
import { Post } from "./post.model";

interface UserInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    passworde: string ;
    dateOfBirth: Date ;
    
}
export class User implements UserInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    passworde: string ;
    dateOfBirth: Date ;
    constructor(obj:UserInterface){
        this.id=obj.id;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.username=obj.username;
        this.passworde=obj.passworde;
        this.dateOfBirth=obj.dateOfBirth;
    } 
}