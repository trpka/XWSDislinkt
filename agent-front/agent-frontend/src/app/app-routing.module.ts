import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllAgentsComponent } from './all-agents/all-agents.component';
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { JobSearchComponent } from './job-search/job-search.component';
import { RegistrationAgentComponent } from './registration-agent/registration-agent.component';

const routes: Routes = 
[
  {path: 'all_jobs', component: AllJobsComponent},
  {path: 'job/create', component: CreateJobOfferComponent},
  {path: 'position/:position', component: JobSearchComponent},
  {path: 'agent/registration',component: RegistrationAgentComponent},
  {path: 'agents', component: AllAgentsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
