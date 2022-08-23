import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  postToAdd:Post;
  posts:Post[];
  idOfUser:any;
  constructor(private postService:PostService, private userService: UserService) { 

    this.postToAdd=new Post(
      {
        id: 0,
        ownerId:0,
        text:"",
        userIdWhoLikes:[],
        userIdWhoDislikes:[],
        comments:[]
      });
      this.posts = [];
  }

  ngOnInit(): void {
    this.reloadData();
    this.loadUser();
  }

  reloadData() {
    this.postService.getPosts()
    .subscribe(res=>this.posts=res);
  }
    

  savePost(){ 
    console.log(this.postToAdd)
    this.postService.save(this.postToAdd)
    .subscribe(_=>this.reloadData())
  }
  loadUser(){
    this.idOfUser = sessionStorage.getItem('id');
    this.postToAdd.ownerId=this.idOfUser;
    /*
    this.userService.findUserById(this.idOfUser)
    .subscribe(res=>this.postToAdd.ownerId=res.id)*/
}
}
