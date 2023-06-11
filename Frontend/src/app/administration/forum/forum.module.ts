import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { ForumRoutingModule } from './forum-routing.module';
import { ListPostComponent } from './list-post/list-post.component';


@NgModule({
  declarations: [
    ListPostComponent
  ],
  imports: [
    CommonModule,

    ForumRoutingModule
  ]
})
export class ForumModule { }
