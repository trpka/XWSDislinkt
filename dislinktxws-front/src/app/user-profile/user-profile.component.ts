import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post.model';
import { NewFollower} from '../model/newFollower';
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
  posts:Post[];
  newFollower: NewFollower;

  idFollower:any;
  idUser: number;
  constructor(private route: ActivatedRoute, private profileService:ProfileService) { }
  
  
  ngOnInit(): void {
    this.loadProfile()
    this.findPosts()
  }

  findPosts(){
    this.id = sessionStorage.getItem('id');
    this.profileService.findAllPostsByOwnerId(this.id).subscribe((res: Post[]) => {
      this.posts = res;
    });
   
  }

  loadProfile(){
    this.id = sessionStorage.getItem('id');
    this.profileService.findProfileById(this.id)
    .subscribe(res=>this.profile=res)
  
  }

  followProfile(){
    this.idFollower = sessionStorage.getItem('id');
  }

}
