import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user';
import { SearchService } from '../service/search.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit 
{
  username:string;
  user:User;
  users:User[];

  
  constructor(private route: ActivatedRoute, private userService:UserService) { }

 

  ngOnInit(): void 
  {
    
    this.loadUser();
  }

  reloadUsers()
  {
     this.userService.getUsers()
     .subscribe(res => this.users = res);
  }

  loadUser()
  {
    this.username = this.route.snapshot.params['username'];
    this.userService.searchByPartUsername(this.username)
    .subscribe(res => this.user=res)
  }

  UpdateUser()
  {
    this.userService.UpdateUser(this.user)
    .subscribe(res => this.user=res)
    window.location.reload()
  }

}
