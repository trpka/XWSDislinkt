import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../model/post.model';
import { NewFollower} from '../model/newFollower';
import { Profile } from '../model/profile';

import { ProfileService } from '../service/profile.service';
import { User } from '../model/user';
import { FollowRequestService } from '../service/follow-request.service';
import { FollowRequest } from '../model/followRequest';
import { PostService } from '../service/post.service';
import { NewLike } from '../model/newLike';
import { NewDislikeDTO } from '../model/newDislikeDTO';



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
  numberOfFollowers: number;
  listOfFollowers1:User[];
  listOfFollowers2:User[];
  showFollowers = false;
  p = false;
  showFollowButtonForLoginUser : boolean;//ne treba
  showSendRequestButtonForLoginUser = false;//ne treba
  profileWhoLikedPost:number;
  profileWhoDislikedPost:number;
  //profileWhichPostWasLiked: number;
  //idPost:number;
  dislikeList : number[];
  newLike : NewLike;
  newDislikeDTO: NewDislikeDTO;
  
  
 
  constructor(private route: ActivatedRoute, private profileService:ProfileService, 
  private followRequestService: FollowRequestService, private postService : PostService, private router: Router) { 
    this.newFollower = new NewFollower({
      idProfileUser : 0,
      idFollowerUser : 0
    }),
    this.newLike= new NewLike({
      idProfileWhoLike : 0,
      likedPost:new Post(
        {
          id: 0,
          ownerId:0,
          text:"",
          userIdWhoLikes:[],
          userIdWhoDislikes:[],
          comments:[],
          numberOfLikes:0,
          numberOfDislikes: 0
        })
    }),

    this.newDislikeDTO= new NewDislikeDTO({
      idProfileWhoDislike : 0,
      dislikedPost:new Post(
        {
          id: 0,
          ownerId:0,
          text:"",
          userIdWhoLikes:[],
          userIdWhoDislikes:[],
          comments:[],
          numberOfLikes:0,
          numberOfDislikes: 0
        })
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


  findPosts(){
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
      };
      /*if(this.profile.privateProfile == true){
        this.showFollowButtonForLoginUser = true;
      }*/
      
      
      
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
      /*this.followRequest.usernameWhoWantToFollow = String(sessionStorage.getItem('username'));
      this.idProfile = Number(this.route.snapshot.params['id']);
      this.profileService.findProfileById(this.idProfile)
      .subscribe(res=>{this.followRequest.username=res.user.username;
        this.followRequestService.save(this.followRequest)
        .subscribe(res=>{this.showFollowButtonForLoginUser = false; this.showSendRequestButtonForLoginUser=true})
      });*/
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
  
  blockProfile(id:number){
    
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

  /*likePost(post:Post){
    this.profileWhoLikedPost = Number(sessionStorage.getItem('id'))
    post.userIdWhoLikes.push(this.profileWhoLikedPost)
    this.postService.likePost(post)
    .subscribe(_=>this.findPosts())
      
  }*/


  likePost1(post:Post){
  this.newLike.idProfileWhoLike = Number(sessionStorage.getItem('id'))
  this.newLike.likedPost = post;
  console.log(this.newLike)
  this.postService.likePost1(this.newLike)
  .subscribe(_=>this.findPosts())
  }

  dislikePost1(post:Post)
  {
    this.newDislikeDTO.dislikedPost = post;
    this.newDislikeDTO.idProfileWhoDislike = Number(sessionStorage.getItem('id'));
    this.postService.dislikePost1(this.newDislikeDTO)
    .subscribe(_=>this.findPosts())

  }


  likeIfPostIsNotLiked(post:Post)
  {
    
  }

  createPostPage()
  {
    this.router.navigate(['/post']);
  }

  addComent(idPost:any){
    this.router.navigate(['/post', idPost]);
  }
}