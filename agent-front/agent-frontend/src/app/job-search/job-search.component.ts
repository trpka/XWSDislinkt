import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    private jobsService: JobsService) 
    {
      this.jobOffer = new JobOffer
    ({
         
         position: "",
         description: "",
        daily_activities: [],
        qualifications: []
    })
    this.position = "";

    }

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
