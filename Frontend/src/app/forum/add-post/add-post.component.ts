import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DateProcessor } from 'src/app/features/DateProcessor';
import { UploadImage } from 'src/app/features/UploadImage';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  uploadedImage!: File;
  post = new Post();

  constructor(
    private uploadImage: UploadImage, 
    private postService: PostService,
    private router: Router,
    private dateProcessor: DateProcessor
    ) { }

  ngOnInit(): void {

  }
  submit(): void {
    this.post.formatedDate = this.dateProcessor.formatDate(new Date())
    this.postService.addPost(this.post).subscribe(
      {
        next: (data) => {
          console.log(data)
          this.router.navigate(['/forume/detail/', { "idPost": data.idPost }])
        }
      }
    )
  }
  
  public onImageUpload(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    this.uploadedImage = files[0];
    this.uploadImage.imageUploadAction(this.uploadedImage).subscribe({
      next: (data) => this.post.imageUrl = environment.baseUrl + '/image/get/' + data,
    })
  }



}
