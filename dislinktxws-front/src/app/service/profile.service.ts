import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../model/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  url="http://localhost:8081/api/profile";

  constructor(private http:HttpClient) {}

  getProfiles():Observable<Profile[]>{
    return this.http.get<Profile[]>(this.url);
  }
  
  save(newProfile:Profile):Observable<Profile>{
    return this.http.post<Profile>(this.url,newProfile);
  }
  findProfileById(id:number):Observable<Profile>{
    return this.http.get<Profile>(`${this.url}/${id}`);
  }
}
