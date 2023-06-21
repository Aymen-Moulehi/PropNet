import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Response } from 'src/app/models/Response';

@Injectable({
  providedIn: 'root'
})
export class ResponseService {

  constructor(private httpClient: HttpClient) {}

  addAndAsginResponseToPost(idPost: number, response: Response) {
    return this.httpClient.post<Response>(environment.baseUrl + '/response/add-and-asgin-response-to-post/' + idPost, response);
  }
}
