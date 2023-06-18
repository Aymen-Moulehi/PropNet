import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { DateProcessor } from 'src/app/features/DateProcessor';
import { StringProcessor } from 'src/app/features/StringProcessor';
import { environment } from 'src/environments/environment';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.css']
})
export class DetailPostComponent implements OnInit {

  postId!: string;
  post!: Post;
  formatedDate!: string;
  relatedTags: string[] = [];

  constructor(
    private activatedRouter: ActivatedRoute, 
    private postService: PostService, 
    private dateProcessor: DateProcessor,
     private stringProcessor: StringProcessor,
    private router: Router,
   
  ) { }

  ngOnInit(): void {
    this.postId = this.activatedRouter.snapshot.params['idPost']
    if (this.postId == undefined)
      this.router.navigate([environment.undefinedPageUrl])
    const isNum = !isNaN(parseInt(this.postId))
    if (isNum) {
      this.postService.getPostById(parseInt (this.postId)).subscribe({
        next: (data) => {
          if(data == undefined)
            this.router.navigate([environment.undefinedPageUrl])
          this.post = data;
          this.relatedTags = this.stringProcessor.extractWordList(data.relatedTags);
          this.formatedDate = this.dateProcessor.formatDate(new Date(data.postDate));
        }
      });
    } else {
      this.router.navigate([environment.undefinedPageUrl])
    }
  }

}
