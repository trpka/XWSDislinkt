import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-all-profiles',
  templateUrl: './all-profiles.component.html',
  styleUrls: ['./all-profiles.component.css']
})
export class AllProfilesComponent implements OnInit {

  profiles: Profile[];
  profile: Profile;
  id : number;
  username: string;

  constructor(private profileService: ProfileService,private router: Router) 
  {
      this.profiles = [];
  }

  ngOnInit(): void 
  {
    this.LoadData();
  }

  LoadData()
  {
    this.profileService.getProfiles()
    .subscribe(res => this.profiles = res);
  }

  userProfile()
  {
    location.pathname = ('find/' + this.username);
  }

  /*FindProfileByUsername()
  {
    console.log(this.username)
    this.profileService.searchProfileByUsername(this.username)
    .subscribe(_=>this.userProfile())

  }*/
  FindProfileByUsername()
  {
    //console.log(this.username)
    this.profileService.searchProfileByUsername(this.username)
    .subscribe(res=>this.router.navigate(['/profile',res.id]))
    
  }

}
