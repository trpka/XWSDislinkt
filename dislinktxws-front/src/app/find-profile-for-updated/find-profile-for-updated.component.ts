import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-find-profile-for-updated',
  templateUrl: './find-profile-for-updated.component.html',
  styleUrls: ['./find-profile-for-updated.component.css']
})
export class FindProfileForUpdatedComponent implements OnInit {

  profile: Profile[];
  id: number; 
  username: string;
  password: string;


  constructor(private profileService: ProfileService, private router: Router) { }

  ngOnInit(): void {
  }

  UserProfileForUpdate()
  {
     location.pathname = ('find/' + this.username);
  }

  FindProfileByUserPass()
  {
    console.log(this.username)
    this.profileService.searchProfileByUsername(this.username)
    .subscribe(_=> this.UserProfileForUpdate())
  }

 

}
