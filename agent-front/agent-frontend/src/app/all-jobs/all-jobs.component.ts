import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobOffer } from '../model/JobOffer';
import { JobsService } from '../service/jobs.service';

@Component({
  selector: 'app-all-jobs',
  templateUrl: './all-jobs.component.html',
  styleUrls: ['./all-jobs.component.css']
})
export class AllJobsComponent implements OnInit {

  jobOffers: JobOffer[];
  jobOffer: JobOffer;
  id: number;

  position: any;

  

  constructor(private jobsService: JobsService, private router: Router) {

    this.jobOffer = new JobOffer
    ({
         
         position: "",
         description: "",
        daily_activities: [],
        qualifications: []
      })
   // this.position = "";
   // this.jobOffers = [];
    
   }

  ngOnInit(): void 
  {
    this.LoadData();
  }

  LoadData()
  {
    this.jobsService.getJobOffers()
    .subscribe(res => this.jobOffers = res)
  }


  JobOfferProfile()
  {
    location.pathname = ('position/' + this.position);
  }

  CreateJobOffer()
  {
    location.pathname = ('job/create/');
  }

}
