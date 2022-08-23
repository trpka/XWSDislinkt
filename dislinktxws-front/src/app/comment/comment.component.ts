import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Comment } from '../model/comment.model';
import { NewComment } from '../model/newComment';
import { Post } from '../model/post.model';
import { CommentService } from '../service/comment.service';
import { PostService } from '../service/post.service';



@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  comments:Comment[];
  idPost:number;
  post:Post;
  //commentToAdd:Comment;

  newCommentForPost:NewComment;
 
  @Output()
  CommentAdded : EventEmitter<Comment> =new EventEmitter();
  
  constructor(private commentService:CommentService, private route: ActivatedRoute, private postService:PostService) { 
    /*this.commentToAdd=new Comment(
    {
      id:"",
      userId:"",
      content:"",
    });*/
    this.newCommentForPost=new NewComment({
      post:new Post(
        {
          id: 0,
          ownerId:0,
          text:"",
          userIdWhoLikes:[],
          userIdWhoDislikes:[],
          comments:[]
        }),
      comment:new Comment(
        {
          id:0,
          userId:"",
          content:"",
        })
    })
    this.comments= [];
  }

  ngOnInit(): void {
    this.reloadData();
    this.loadPost();
  }

  loadPost() {
    this.idPost = this.route.snapshot.params['idPost'];
    this.postService.findPostById(this.idPost)
    .subscribe(res=>this.post=res)
  }
  

  reloadData() {
    this.commentService.getComments()
    .subscribe(res=>this.comments=res)
  }

  saveComment(){
    this.newCommentForPost.post=this.post;
    this.commentService.save(this.newCommentForPost)
    .subscribe(_=>this.reloadData)
  }

 
  /*
  saveComment(){ 
    console.log(this.commentToAdd)
    this.commentService.save(this.commentToAdd)
    .subscribe()
  }*/
}
