import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post.model';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  url="http://localhost:8081/api/post";

  constructor(private http:HttpClient) {}

  getPosts():Observable<Post[]>{
    return this.http.get<Post[]>(this.url);
  }
  
  save(newPost:Post):Observable<Post>{
    return this.http.post<Post>(this.url,newPost);
  }
  findPostById(id:number):Observable<Post>{
    return this.http.get<Post>(`${this.url}/${id}`);
  }

  likePost(post:Post):Observable<Post>{
    return this.http.post<Post>(this.url+"/likePost",post);
  }  

  dislikePost(post:Post):Observable<Post>{
    return this.http.post<Post>(this.url+"/dislikePost",post);
  } 

}
