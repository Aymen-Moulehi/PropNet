import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Post} from 'src/app/models/Post';
import {PostService} from 'src/app/services/post.service';
import {DateProcessor} from 'src/app/features/DateProcessor';
import {StringProcessor} from 'src/app/features/StringProcessor';
import {environment} from 'src/environments/environment';
import {Response} from 'src/app/models/Response';
import {ResponseService} from 'src/app/services/response.service';
import { HttpResponse } from '@angular/common/http';
import { SaveFile } from 'src/app/features/SaveFile';

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
  responses!:[Response];
  userResponse!: Response;

  constructor(
    private activatedRouter: ActivatedRoute,
    private postService: PostService,
    private dateProcessor: DateProcessor,
    private stringProcessor: StringProcessor,
    private router: Router,
    private responseService : ResponseService,
    private fileSaver: SaveFile
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
          this.responses = data.responses as unknown as [Response] ;
          this.relatedTags = this.stringProcessor.extractWordList(data.relatedTags);
          this.formatedDate = this.dateProcessor.formatDate(new Date(data.postDate));
        }
      });
    } else {
      this.router.navigate([environment.undefinedPageUrl])
    }
    this.userResponse = new Response();
  }

  addComment() {
    const responseElement = new Response()
    responseElement.author = "Rosalina Kelian";
    responseElement.content = this.userResponse.content;
    responseElement.responseDate  = new Date();
    responseElement.formatedDate = this.dateProcessor.formatDate(responseElement.responseDate);

    this.responseService.addAndAsginResponseToPost(this.post.idPost, responseElement).subscribe({
      next: (data) => {
        this.responses.push(responseElement);
        this.userResponse.content = "   ";
      }
    });
  }

  downloadPdfPost(): void {
    this.postService.downloadPostPDF(this.post.idPost).subscribe(res => {
      const filename = 'file.pdf';
      this.fileSaver.save(res.body as ArrayBuffer, filename);
    });
  }
}
