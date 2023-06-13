import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UploadImage } from 'src/app/features/upload-image/UploadImage';


@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  uploadedImage!: File;

  postForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    file: new FormControl('', [Validators.required]),
    fileSource: new FormControl('', [Validators.required])
  });

  constructor(private uploadImage: UploadImage) { }

  ngOnInit(): void {
  }
  submit(): void {

  }

  public onImageUpload(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    console.log(files);
    this.uploadedImage = files[0];
  }

  public imageUploadAction() {
    // The return of this method is a string contain the URL to the image
    this.uploadImage.imageUploadAction(this.uploadedImage).subscribe(
      {
        next : (data) => console.log(data),
        error : (error) => console.log(error),
        complete : () => console.log("done") 
      }
     )
  }


}
