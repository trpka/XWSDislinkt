import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommentComponent } from './comment/comment.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { OnePostComponent } from './one-post/one-post.component';
import { PostComponent } from './post/post.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path:'post/:id',component:OnePostComponent},
  {path: 'newComment/:idPost', component:CommentComponent},
  {path: 'post', component: PostComponent},
  {path: 'user/:id', component:ProfileComponent},
  {path: 'login', component:LoginPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
