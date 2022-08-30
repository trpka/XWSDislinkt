import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateJobOfferComponent } from '../create-job-offer/create-job-offer.component';
import { JobOffer } from '../model/JobOffer';
import { JobsService } from '../service/jobs.service';


@Component({
  selector: 'app-job-search',
  templateUrl: './job-search.component.html',
  styleUrls: ['./job-search.component.css']
})
export class JobSearchComponent implements OnInit {

  position: string;
  jobOffer: JobOffer;

  listOfQualifications:string = '';


  constructor(private route: ActivatedRoute, private router: Router, 
    private jobsService: JobsService) { }

  ngOnInit(): void 
  {
    this.loadJobOffer();
  }


  loadJobOffer()
  {
    this.position = this.route.snapshot.params['position'];
    this.jobsService.getJobByPosition(this.position)
    .subscribe(res => {this.jobOffer = res;
    this.insertQualificationsIntoString(res.qualifications)})
  }
  
  Back()
  {
    this.router.navigate(['all_jobs']);

  }


  insertQualificationsIntoString(qualifications: string[])
  {
    var listQualifications:string[]=[];
    qualifications.forEach(function(lan:string)
    {
      listQualifications.push(lan);
    })

    this.listOfQualifications = listQualifications.join(",");
  }

}
