import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  id:number;
  user:User;
  constructor(private route: ActivatedRoute, private userService:UserService) { }

  ngOnInit(): void {
    this.loadPost();
  }

  loadPost(){
    this.id = this.route.snapshot.params['id'];
    this.userService.findUserById(this.id)
    .subscribe(res=>this.user=res)
  }

}
