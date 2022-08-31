import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AgentUser } from '../model/AgentUser';

@Injectable({
  providedIn: 'root'
})
export class AgentServiceService 
{
  url = "http://localhost:8084/api/agent/registration";
  url1 = "http://localhost:8084/api/agents";

  constructor(private http: HttpClient) { }


  getAgents():Observable<AgentUser[]>
  {
    return this.http.get<AgentUser[]>(this.url1);
  }

  registrationAgent(newAgent:AgentUser):Observable<AgentUser>
  {
    return this.http.post<AgentUser>(this.url,newAgent);
  }

}
