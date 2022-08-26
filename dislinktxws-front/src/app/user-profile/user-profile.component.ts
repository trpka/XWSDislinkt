import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../model/post.model';
import { NewFollower} from '../model/newFollower';
import { Profile } from '../model/profile';

import { ProfileService } from '../service/profile.service';
import { User } from '../model/user';
import { FollowRequestService } from '../service/follow-request.service';
import { FollowRequest } from '../model/followRequest';

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
  id1:number;
  followRequests:FollowRequest[];
  followerUsername:string;
  numberOfFollowers: number;
  listOfFollowers1:User[];
  showFollowers = false;
 
  constructor(private route: ActivatedRoute, private profileService:ProfileService, 
  private followRequestService: FollowRequestService) { 
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
      privateProfile: true,
      followers : []
    }),
    this.followRequest = new FollowRequest({
      username:"",
      usernameWhoWantToFollow:"",
      followRequest:false
    })
    this.followRequests=[];
    this.numberOfFollowers = 0;
  }
  
  
  ngOnInit(): void {
    this.loadProfile()
    this.findProfiles()
    //this.findAll()
    this.findFollowRequests()
    this.listOfFollowers()
    this.showFollowButton()
  }


  findProfiles(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.findAllPostsByOwnerId(this.id).subscribe((res: Post[]) => {
      this.posts = res;
    });
   
  }


  loadProfile(){
    this.id = this.route.snapshot.params['id'];
    this.profileService.findProfileById(this.id)
    .subscribe(res=>{this.profile=res;
      for(var val of this.profile.followers)
      { 
        this.numberOfFollowers++;
      }
      
      
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

  listOfFollowers()
  {
    this.id1 = this.route.snapshot.params['id'];
    this.profileService.findAllFollowers(this.id1)
    .subscribe(res=>{this.listOfFollowers1=res;
      console.log(res)
    })
  }
  
  blockUser(){

  }

  acceptRequest(f:FollowRequest)
  {
    console.log(f)
    this.followRequestService.acceptRequest(f)
    .subscribe(_=>this.findFollowRequests())
  }

  seeAllFollowers():boolean
  {
    this.showFollowers = true;
    return this.showFollowers;
  }

  showFollowButton():boolean
  {
    if(Number(this.route.snapshot.params['id']) == Number(sessionStorage.getItem('id')))
    {
      return false;
    }
   return true;
  }
}
