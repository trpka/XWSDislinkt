import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post.model';
import { NewFollower} from '../model/newFollower';
import { Profile } from '../model/profile';

import { ProfileService } from '../service/profile.service';
import { User } from '../model/user';
import { FollowRequestService } from '../service/follow-request.service';
import { FollowRequest } from '../model/followRequest';
import { AuthenticationService } from '../service/authentication.service';

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
  followRequest: FollowRequest;
  idProfile:number;
  followRequests:FollowRequest[];
  followerUsername:string;
  update_profile: Profile;
  profiles: Profile[];
  user: User;
  logged_username: string;
  logged_profile: boolean;
 
  constructor(private route: ActivatedRoute, private profileService:ProfileService, 
  private followRequestService: FollowRequestService, private authService: AuthenticationService) { 
    this.newFollower = new NewFollower({
      idProfileUser : 0,
      idFollowerUser : 0
    }),
    
    this.profile = new Profile({
      user : new User({
      id: 0,
      firstName: "",
      lastName: "",
      email: "",
      username: "",
      password: "",
      dateOfBirth: "" 
      }) ,
      experience:[],
      education:[],
      interests:[],
      skills:[],
      privateProfile: true
    }),
    this.followRequest = new FollowRequest({
      username:"",
      usernameWhoWantToFollow:"",
      followRequest:false
    })
    this.followRequests=[];
  }
  
  
  ngOnInit(): void {
    this.loadProfile()
    this.findProfiles()
    //this.findAll()
    this.findFollowRequests()
   
  }

  //Izmena Podataka za Korisnika
  UpdateProfile()
  {
    window.location.reload()
    
  }

  findProfiles(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.findAllPostsByOwnerId(this.id).subscribe((res: Post[]) => {
      this.posts = res;
    });
   
  }


  loadProfile(){
    this.authService.isUserLoggedIn
   // this.logged_profile = false;
    this.id = this.route.snapshot.params['id'];
    this.profileService.findProfileById(this.id)
    .subscribe(res=>{this.profile=res;  
      console.log(this.profile.user.username);
      console.log(this.profile.privateProfile)
    })


  }

  followProfile(){
    if(this.profile.privateProfile == false){
    this.newFollower.idFollowerUser = Number(sessionStorage.getItem('id')); 
    this.newFollower.idProfileUser = Number(this.route.snapshot.params['id']);
    console.log(this.newFollower)
    this.profileService.followProfile(this.newFollower)
    .subscribe()
    }
    else
    {
      this.followRequest.usernameWhoWantToFollow = String(sessionStorage.getItem('username'));
      this.idProfile = Number(this.route.snapshot.params['id']);
      this.profileService.findProfileById(this.idProfile)
      .subscribe(res=>{this.followRequest.username=res.user.username;
        this.followRequestService.save(this.followRequest)
        .subscribe()
      });
    }
    
  }

  findAll(){
    this.followRequestService.getFollowRequests()
    .subscribe(res=>this.followRequests=res)
  }

  findFollowRequests(){
    this.followerUsername = String(sessionStorage.getItem('username'));
    this.followRequestService.findAllFollowRequestsByFollowerUsername(this.followerUsername)
    .subscribe(res=>this.followRequests=res);
    //.subscribe((res: FollowRequest[]) => {this.followRequests = res; });
   
    
   
  }
  

}
