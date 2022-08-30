import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { AllProfilesComponent } from './all-profiles/all-profiles.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { CommentComponent } from './comment/comment.component';
import { CreateJobOfferComponent } from './create-job-offer/create-job-offer.component';
import { FindProfileForUpdatedComponent } from './find-profile-for-updated/find-profile-for-updated.component';
import { JobSearchComponent } from './job-search/job-search.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { OnePostComponent } from './one-post/one-post.component';
import { PostComponent } from './post/post.component';
import { ProfileSearchComponent } from './profile-search/profile-search.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { UserProfileComponent } from './user-profile/user-profile.component';


const routes: Routes = [
  {path:'post/:id',component:OnePostComponent},
  {path: 'newComment/:idPost', component:CommentComponent},
  {path: 'post', component: PostComponent},
  {path: 'user/:id', component:ProfileComponent},

  {path: 'login', component:LoginPageComponent},

  {path: 'search/:username',component:SearchComponent},
  {path: 'users',component:AllUsersComponent},
  {path: 'registration',component: RegistrationComponent},

  {path: 'profile/:id',component: UserProfileComponent},

  {path: 'profile',component: UserProfileComponent},
  {path: 'profiles', component: ProfileComponent},
  {path: 'all_profiles', component: AllProfilesComponent},
  {path: 'find/:username',component: ProfileSearchComponent},
  {path: 'find_profile_update', component: FindProfileForUpdatedComponent},
  {path: 'all_jobs', component: AllJobsComponent},
  {path: 'position/:position', component: JobSearchComponent},
  {path: 'job/create', component:CreateJobOfferComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
