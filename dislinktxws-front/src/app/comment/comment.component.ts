import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Comment } from '../model/comment.model';
import { CommentService } from '../service/comment.service';


@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  commentToAdd:Comment;
  @Output()
  CommentAdded : EventEmitter<Comment> =new EventEmitter();
  constructor(private commentService:CommentService) { 
    this.commentToAdd=new Comment({
      id:"",
      userId:"",
      content:"",
    });
  }

  ngOnInit(): void {
  }

  
  saveComment(){

    
    console.log(this.commentToAdd)
    this.commentService.save(this.commentToAdd)
    .subscribe()
  }
}
