import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.css']
})
export class DetailPostComponent implements OnInit {

  postId!: string;
  post!: Post;
  constructor(private activatedRouter : ActivatedRoute, private postService : PostService, private router: Router) { }

  ngOnInit(): void {
    this.postId = this.activatedRouter.snapshot.params['idPost']
    if(this.postId == undefined)
    this.router.navigate(['**'])
    const isNum = !isNaN(parseInt(this.postId))
    if(isNum) {
      this.postService.getPostById(parseInt(this.postId)).subscribe({
        next: (data) => this.post = data,
      });
    } else {
      this.router.navigate(['**'])
    }
  }

}
