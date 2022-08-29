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

  constructor(private route: ActivatedRoute, private router: Router, private jobsService: JobsService) { }

  ngOnInit(): void 
  {
    this.loadJobOffer();
  }


  loadJobOffer()
  {
    this.position = this.route.snapshot.params['position'];
    this.jobsService.getJobByPosition(this.position)
    .subscribe(res => this.jobOffer = res)
  }
  
  Back()
  {
    this.router.navigate(['all_jobs']);

  }

}
