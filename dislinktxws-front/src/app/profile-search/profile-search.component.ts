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
export class ProfileSearchComponent implements OnInit 
{
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
     //this.findProfileById();
     //this.findPosts();
  }

  loadProfile()
  {
     this.username = this.route.snapshot.params['username'];
     this.profileService.searchProfileByUsername(this.username)
    .subscribe(res => this.profile=res)

    this.findPosts()


  }

  //Pretraga Profila Po ID-ju, zato sto ne mozemo kasnije, postove 
  //pronaci po username-u, mora ID
  findProfileById()
  {
    //this.id = sessionStorage.getItem('id');
    this.id = this.route.snapshot.params['id'];
    this.profileService.findProfileById(this.id)
    .subscribe(res=>this.profile=res)
  }

  findPosts()
  {
    this.id = sessionStorage.getItem('id');


    this.profileService.findAllPostsByOwnerId(2).subscribe((res: Post[]) => {
      this.posts = res;
    });
  }  

  UpdateProfile()
  {
    this.profileService.UpdateProfile(this.profile)
    .subscribe(res => this.profile=res)
    window.location.reload()
  }

}
