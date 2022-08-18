import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment.model';
import { NewComment } from '../model/newComment';
import { Post } from '../model/post.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  url="http://localhost:8081/api/comment";
  constructor(private http:HttpClient) {}

  getComments():Observable<Comment[]>{
    return this.http.get<Comment[]>(this.url);
}
  /*
  save(newComment:Comment):Observable<Comment>{
    return this.http.post<Comment>(this.url,newComment);
  }*/
  save(newComment:NewComment):Observable<Post>{
    return this.http.post<Post>(this.url,newComment);
  }
  
}
