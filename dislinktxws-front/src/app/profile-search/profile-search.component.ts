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
  password: string;
  listsOfExperiance:string='';
  

  idFollower:any;
  idUser: number;

  experiences=['jedan','dva','tri','cetiri'];

  
  
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
     this.password = this.route.snapshot.params['password'];
    
    this.profileService.searchProfileByUsername(this.username)
    .subscribe(res =>{this.profile=res;this.insertExperianceIntoString(res.experience)})
   

    this.findPosts()


  }

  

  findPosts()
  {
    this.id = sessionStorage.getItem('id');


    this.profileService.findAllPostsByOwnerId(this.profile.user.id).subscribe((res: Post[]) => {
      this.posts = res;
    });
  }  

  UpdateProfile()
  {
    this.profile.experience=this.listsOfExperiance.split(",");
    this.profileService.UpdateProfile(this.profile)
    .subscribe(res => this.profile=res)
    window.location.reload()
  }
  
  insertExperianceIntoString(experiance:string[]){
    var listsExperiance:string[]=[];
    experiance.forEach(function(lan:string){
      listsExperiance.push(lan)
    })
    this.listsOfExperiance=listsExperiance.join(",")
  }

}
