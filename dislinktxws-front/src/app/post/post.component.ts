import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  postToAdd:Post;
  posts:Post[];
  constructor(private postService:PostService) { 

    this.postToAdd=new Post(
      {
        id: 0,
        ownerId:"",
        text:"",
        likes:[],
        dislikes:[],
        comments:[]
      });
      this.posts = [];
  }

  ngOnInit(): void {
    this.reloadData();
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
}
