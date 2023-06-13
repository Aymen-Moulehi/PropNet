import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UploadImage {

  defaultImageUrl = "https://hd2.tudocdn.net/972897?w=1200&h=675"

  constructor(private httpClient: HttpClient) { }

  imageUploadAction(uploadedImage: File) {
    const imageFormData = new FormData();
    imageFormData.append('image', uploadedImage, uploadedImage.name);
    return this.httpClient.post(environment.baseUrl + '/image/upload', imageFormData, { responseType: 'text' });
  }
}