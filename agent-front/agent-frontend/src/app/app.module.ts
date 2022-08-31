import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { NavbarComponent } from './navbar/navbar.component';
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { HttpClientModule } from '@angular/common/http';
import { JobSearchComponent } from './job-search/job-search.component';
import { FormsModule } from '@angular/forms';
import { RegistrationAgentComponent } from './registration-agent/registration-agent.component';
import { AllAgentsComponent } from './all-agents/all-agents.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AllJobsComponent,
    CreateJobOfferComponent,
    JobSearchComponent,
    RegistrationAgentComponent,
    AllAgentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
