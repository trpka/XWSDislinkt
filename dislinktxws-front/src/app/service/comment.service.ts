import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  url="http://localhost:8081/api/comment";
  constructor(private http:HttpClient) { }
  
  save(newItem:Comment):Observable<Comment>{
    return this.http.post<Comment>(this.url,newItem);
  }
}
