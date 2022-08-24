import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post.model';
import { Profile } from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  url="http://localhost:8081/api/profile";
  ur2="http://localhost:8081/api/profile/posts";

  constructor(private http:HttpClient) {}

  getProfiles():Observable<Profile[]>{
    return this.http.get<Profile[]>(this.url);
  }

  findAllPostsByOwnerId(id:number):Observable<Post[]>{
    return this.http.get<Post[]>(`${this.ur2}/${id}`);
  }
  
  save(newProfile:Profile):Observable<Profile>{
    return this.http.post<Profile>(this.url,newProfile);
  }
  findProfileById(id:number):Observable<Profile>{
    return this.http.get<Profile>(`${this.url}/${id}`);
  }


}
