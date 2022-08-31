interface AgentUserInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    password: string ;
    phone: string ;
    
}
export class AgentUser implements AgentUserInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    password: string ;
    phone: string ;
    constructor(obj:AgentUserInterface){
        this.id=obj.id;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.username=obj.username;
        this.password=obj.password;
        this.phone=obj.phone;
    } 
   
}