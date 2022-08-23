import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  url = "http://localhost:8081/api/search";

  constructor(private http:HttpClient) { }

  searchByPartUsername(username:string):Observable<User>
  {
    return this.http.get<User>(`${this.url}/${username}`)
  }

}
