import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../model/post.model';
import { NewFollower} from '../model/newFollower';
import { Profile } from '../model/profile';

import { ProfileService } from '../service/profile.service';
import { User } from '../model/user';
import { FollowRequestService } from '../service/follow-request.service';
import { FollowRequest } from '../model/followRequest';
import { AuthenticationService } from '../service/authentication.service';

import { PostService } from '../service/post.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  id:any;
  profile:Profile;
  profile1:Profile;
  posts:Post[];
  newFollower: NewFollower;
  followRequest: FollowRequest;
  idProfile:number;
  id1:number;
  id2:number;
  id3:number;
  id4:number;
  followRequests:FollowRequest[];
  followerUsername:string;

  update_profile: Profile;
  profiles: Profile[];
  user: User;
  logged_username: string;
  logged_profile: boolean;
 
  constructor(private route: ActivatedRoute, private profileService:ProfileService, 
  private followRequestService: FollowRequestService, private authService: AuthenticationService) { 

  numberOfFollowers: number;
  listOfFollowers1:User[];
  listOfFollowers2:User[];
  showFollowers = false;
  p = false;
  showFollowButtonForLoginUser : boolean;
  showSendRequestButtonForLoginUser = false;
  profileWhoLikedPost:number;
  profileWhoDislikedPost:number;
  //profileWhichPostWasLiked: number;
  //idPost:number;
  
 
  constructor(private route: ActivatedRoute, private profileService:ProfileService, 
  private followRequestService: FollowRequestService, private postService : PostService, private router: Router) { 

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
    this.findPosts()
    //this.findAll()
    this.findFollowRequests()
    this.listOfFollowers()
    this.showFollowButton()
  }

  //Izmena Podataka za Korisnika
  UpdateProfile()
  {
    window.location.reload()
    
  }

  findPosts(){
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
      for(var val of this.profile.followers)
      { 
        this.numberOfFollowers++;
      };
      if(this.profile.privateProfile == true){
        this.showFollowButtonForLoginUser = true;
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
        .subscribe(res=>{this.showFollowButtonForLoginUser = false; this.showSendRequestButtonForLoginUser=true})
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

  dontShowRequestPublicLogedUser()
  {
    this.id4 = Number(sessionStorage.getItem('id'))
    this.profileService.findProfileById(this.id4)
    .subscribe(res=>this.profile1=res)

  }

  showFollowButton():boolean
  {
    if(Number(this.route.snapshot.params['id']) == Number(sessionStorage.getItem('id')))
    {
      return false;
    }
   return true;
  }

  showPostsOnPrivateProfile():boolean
  {
    this.id3 = Number(sessionStorage.getItem('id'))
    this.id2 = Number(this.route.snapshot.params['id']);
    this.profileService.findAllFollowers(this.id2)
    .subscribe(res=>{this.listOfFollowers2=res;
      for(var val of this.listOfFollowers2)
      { 
        if(val.id == this.id3){
            this.p = true;
        }
      }
    })
    return this.p;
  }

  likePost(post:Post){
    this.profileWhoLikedPost = Number(sessionStorage.getItem('id'))
    post.userIdWhoLikes.push(this.profileWhoLikedPost)
    this.postService.likePost(post)
    .subscribe(_=>this.findPosts())
    
  }

  dislikePost(post:Post){
    this.profileWhoDislikedPost = Number(sessionStorage.getItem('id'))
    post.userIdWhoDislikes.push(this.profileWhoDislikedPost)
    this.postService.dislikePost(post)
    .subscribe(_=>this.findPosts())
  }

  createPostPage()
  {
    this.router.navigate(['/post']);
  }

  addComent(idPost:any){
    this.router.navigate(['/post', idPost]);
  }
}
