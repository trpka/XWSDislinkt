import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post.model';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';


@Component({
  selector: 'app-profile-search',
  templateUrl: './profile-search.component.html',
  styleUrls: ['./profile-search.component.css']
})
export class ProfileSearchComponent implements OnInit {
  id:any;
  profile:Profile;
  posts:Post[];
  username:string;

  idFollower:any;
  idUser: number;
  
  
  constructor(private route: ActivatedRoute, private profileService:ProfileService) { }

  ngOnInit(): void 
  {
     this.loadProfile();
  }

  loadProfile()
  {
     this.username = this.route.snapshot.params['username'];
     this.profileService.searchProfileByUsername(this.username)
     .subscribe(res => this.profile=res)
  }

}
