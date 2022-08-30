import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewDislikeDTO } from '../model/newDislikeDTO';
import { NewLike } from '../model/newLike';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-profiles-ifollow-posts',
  templateUrl: './profiles-ifollow-posts.component.html',
  styleUrls: ['./profiles-ifollow-posts.component.css']
})
export class ProfilesIFollowPostsComponent implements OnInit {
  posts:Post[];
  id1:number;
  newLike : NewLike;
  newDislikeDTO: NewDislikeDTO;
  

  constructor(private postService:PostService, private router: Router) { 
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
    })
  }

  ngOnInit(): void {
    this.findPosts()
  }

  //tu pozivam moju funkciju sa bekenda, moze da bude problem u res pa mozda treba ona lista da se doda , drugi nacin
  findPosts(){
    this.id1 =  Number(sessionStorage.getItem('id'))
    this.postService.findAllPostsFromProfilesYouFollow(this.id1)
    .subscribe(res=>this.posts=res)
    }
   
  

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

  addComent(idPost:any){
    this.router.navigate(['/post', idPost]);
  }
}
