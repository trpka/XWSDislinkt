import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewFollower } from '../model/newFollower';
import { Post } from '../model/post.model';
import { Profile } from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  url="http://localhost:8081/api/profile";
  ur2="http://localhost:8081/api/profile/posts";
  url3="http://localhost:8081/api/find";
  url4 = "http://localhost:8081/api/edit";
  url5 = "http://localhost:8081/api/id";

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


  followProfile(newFollower:NewFollower):Observable<Profile>{
    return this.http.post<Profile>(this.url+"/follower",newFollower);
  }

   /*searchProfileByUsername(username:string):Observable<Profile>
   {
      return this.http.get<Profile>(`${this.url3}/${username}`)
   }*/

   searchProfileByUsername(username:string):Observable<Profile>
   {
    const params:HttpParams=new HttpParams().append('username',username);
    return this.http.get<Profile>(this.url,{params});
      
   }

   UpdateProfile(profile:Profile):Observable<Profile>
   {
    return this.http.put<Profile>(this.url4,profile);
   }

   /*findUserIdFromProfile(username:string)
   {
    //return this.http.get<number>(`${this.url5}/${username}`);
    //return this.http.get(`${this.url5}/${username}`);

   }*/

  
   



}
