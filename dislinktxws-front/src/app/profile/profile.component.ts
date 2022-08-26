import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user';
import { ProfileService } from '../service/profile.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user:User;
  id:number;
  constructor(private route: ActivatedRoute,private userService:UserService,private profileService: ProfileService) { }

  ngOnInit(): void {
    this.loadPost();
  }

  loadPost(){
    this.id = this.route.snapshot.params['id'];
    this.userService.findUserById(this.id)
    .subscribe(res=>this.user=res)
  
  }

}
