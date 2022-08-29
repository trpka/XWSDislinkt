import { Component, OnInit } from '@angular/core';
import { JobOffer } from '../model/JobOffer';
import { JobsService } from '../service/jobs.service';

@Component({
  selector: 'app-create-job-offer',
  templateUrl: './create-job-offer.component.html',
  styleUrls: ['./create-job-offer.component.css']
})
export class CreateJobOfferComponent implements OnInit {

  newOffer: JobOffer;
  newOffers: JobOffer[];   

  constructor(private jobsService: JobsService) 
  {
      this.newOffer = new JobOffer
      (
        {
          id:0,
          position: "",
          description: "",
          daily_activities: [],
          qualifications: []

        }
      )
 

  }

  ngOnInit(): void 
  {
     this.CreateJobOffer();
  }


  CreateJobOffer()
  {
    console.log(this.newOffer)
    this.jobsService.createNewOffer(this.newOffer)
    .subscribe(res => this.newOffer = res)
  }

}
