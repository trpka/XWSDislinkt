import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url="http://localhost:8081/api/user";
  url1 = "http://localhost:8081/api/search";
  url2 = "http://localhost:8081/api/users";
  url3 = "http://localhost:8081/api/update";
  
  constructor(private http:HttpClient) { }

  save(newUser:User):Observable<User>{
    return this.http.post<User>(this.url,newUser);
  }

  findUserById(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
  
  //Dobavljanje svih Usera
  getUsers():Observable<User[]>
  {
    return this.http.get<User[]>(this.url2);
  }

  //Pronalazenje Korisnika Po Korisnickom Imenu
  searchByPartUsername(username:string):Observable<User>
  {
    return this.http.get<User>(`${this.url1}/${username}`)
  }

  UpdateUser(user:User):Observable<User>
  {
    return this.http.put<User>(this.url3,user);
  }

  //Lista korisnika po delu korisnickog imena
  /*searchByPartUsername(username:string):Observable<User[]>
  {
    return this.http.get<User[]>(`${this.url1}/${username}`)
  }*/


}
