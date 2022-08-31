import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { JobSearchComponent } from './job-search/job-search.component';

const routes: Routes = 
[
  {path: 'all_jobs', component: AllJobsComponent},
  {path: 'job/create', component: CreateJobOfferComponent},
  {path: 'position/:position', component: JobSearchComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
