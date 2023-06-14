import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ForumRoutingModule } from './forum-routing.module';
import { ListPostComponent } from './list-post/list-post.component';
import { AddPostComponent } from './add-post/add-post.component';
import { DetailPostComponent } from './detail-post/detail-post.component';


@NgModule({
  declarations: [
    ListPostComponent,
    AddPostComponent,
    DetailPostComponent
  ],
  imports: [
    CommonModule,
    ForumRoutingModule
  ]
})
export class ForumModule { }
