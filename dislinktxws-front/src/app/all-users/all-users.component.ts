import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {

  users: User[];
  user:  User;
  username: string;
  foundUser: User;
  constructor( private userService: UserService) 
  {

       this.users = [];

  }

  ngOnInit(): void 
  {
    this.LoadData();
  }

  LoadData()
  {
    this.userService.getUsers()
    .subscribe(res => this.users=res);
  }

  userProfile()
  {
      location.pathname = ('search/' + this.username);

  }
 

  FindUserByUsername()
  {

    console.log(this.username)
    this.userService.searchByPartUsername(this.username)
    .subscribe(_=>this.userProfile())

    
    
    
  }

}
