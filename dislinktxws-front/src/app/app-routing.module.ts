import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUsersComponent } from './all-users/all-users.component';
import { CommentComponent } from './comment/comment.component';
import { OnePostComponent } from './one-post/one-post.component';
import { PostComponent } from './post/post.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path:'post/:id',component:OnePostComponent},
  {path: 'newComment/:idPost', component:CommentComponent},
  {path: 'post', component: PostComponent},
  {path: 'user/:id', component:ProfileComponent},
  {path: 'search/:username',component:SearchComponent},
  {path: 'users',component:AllUsersComponent},
  {path: 'registration',component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
