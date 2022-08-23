import { User } from "./user";

interface ProfileInterface{
    id?:number;
    user: User;
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    isPrivate: boolean;
    
}
export class Profile implements ProfileInterface{
    id?:number;
    user: User;
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    isPrivate: boolean;
   
    constructor(obj:ProfileInterface){
        this.id=obj.id;
        this.user=obj.user;
        this.experience=obj.experience;
        this.education=obj.education;
        this.interests=obj.interests;
        this.skills=obj.skills;
        this.isPrivate=obj.isPrivate;
        
    } 
}