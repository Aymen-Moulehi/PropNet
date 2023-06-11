import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPostComponent } from './add-post/add-post.component';
import { DetailPostComponent } from './detail-post/detail-post.component';
import { ListPostComponent } from './list-post/list-post.component';

const routes: Routes = [
  {path:'list', component: ListPostComponent}, 
  {path:'detail', component: DetailPostComponent}, 
  {path:'add', component: AddPostComponent}, 



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForumRoutingModule { }
