import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url="http://localhost:8081/api/user";
  
  constructor(private http:HttpClient) { }

  save(newUser:User):Observable<User>{
    return this.http.post<User>(this.url,newUser);
  }

  findUserById(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
}
