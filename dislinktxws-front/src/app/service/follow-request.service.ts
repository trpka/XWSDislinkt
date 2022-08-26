import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FollowRequest } from '../model/followRequest';
import { Profile } from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class FollowRequestService {

  url="http://localhost:8081/api/followRequest";
  constructor(private http:HttpClient) { }

  save(followRequest:FollowRequest):Observable<FollowRequest>{
    return this.http.post<FollowRequest>(this.url,followRequest);
  }

  acceptRequest(followRequest:FollowRequest):Observable<Profile>{
    return this.http.post<Profile>(this.url + "/request",followRequest);
  }

  getFollowRequests():Observable<FollowRequest[]>{
    return this.http.get<FollowRequest[]>(this.url);
}


findAllFollowRequestsByFollowerUsername(username:string):Observable<FollowRequest[]>{
  const params:HttpParams=new HttpParams().append('username',username);
  return this.http.get<FollowRequest[]>(this.url+"/profile",{params});
}

}
