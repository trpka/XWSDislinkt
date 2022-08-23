import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  id:any;
  profile:Profile;
  constructor(private route: ActivatedRoute, private profileService:ProfileService) { }

  ngOnInit(): void {
    this.loadPost()
  }

  loadPost(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.findProfileById(this.id)
    .subscribe(res=>this.profile=res)
  
  }

}
