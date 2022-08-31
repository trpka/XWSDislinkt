import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JobOffer } from '../model/JobOffer';

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  url = "http://localhost:8083/api/jobs";
  url1 = "http://localhost:8083/api/job/create";
  url2 = "http://localhost:8083/api/job";
  url3 = "http://localhost:8083/api/position";

  constructor(private http:HttpClient) { }

  getJobOffers():Observable<JobOffer[]>
  {
    return this.http.get<JobOffer[]>(this.url);
  }

  
  getJobById(id:number):Observable<JobOffer>
  {
    return this.http.get<JobOffer>(`${this.url2}/${id}`);
  }

  getJobByPosition(position:string):Observable<JobOffer>
  {
     return this.http.get<JobOffer>(`${this.url3}/${position}`);

  }

  createNewOffer(newOffer: JobOffer):Observable<JobOffer>
  {
    return this.http.post<JobOffer>(this.url1,newOffer);
  }



}
