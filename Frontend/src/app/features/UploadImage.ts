import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {environment} from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UploadImage {
  constructor(private httpClient: HttpClient) { }

  imageUploadAction(uploadedImage: File) {
    const imageFormData = new FormData();
    imageFormData.append('image', uploadedImage, uploadedImage.name);
    return this.httpClient.post(environment.baseUrl + '/image/upload', imageFormData, { responseType: 'text' });
  }
}
