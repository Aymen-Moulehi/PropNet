import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ForumRoutingModule } from './forum-routing.module';
import { ListPostsComponent } from './list-posts/list-posts.component';
import { FilterForumComponent } from './filter-forum/filter-forum.component';


@NgModule({
  declarations: [
    ListPostsComponent,
    FilterForumComponent
  ],
  imports: [
    CommonModule,
    ForumRoutingModule
  ]
})
export class ForumModule { }
