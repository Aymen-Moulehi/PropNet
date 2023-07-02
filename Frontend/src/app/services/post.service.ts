import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Post } from '../models/Post';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) {  }
  addPost(post: Post) {
    return this.httpClient.post<Post>(environment.baseUrl + '/post/add-post', post);
  }

  getPostById(id: number) {
    return this.httpClient.get<Post>(environment.baseUrl + '/post/find-post/' + id);
  }
  getPostsAccepted() {

    return this.httpClient.get<Post[]>(environment.baseUrl + '/post/accepted');
  }
  getPostsPending() {
    return this.httpClient.get<Post[]>(environment.baseUrl + '/post/pending');
  }
  getPosts() {
    return this.httpClient.get<Post[]>(environment.baseUrl + '/post/posts');
  }
  deletePosts(id: number) {
    return this.httpClient.delete<Post>(environment.baseUrl + '/post/delete/'+ id);
  }

  updatePosts(post: Post) {
    return this.httpClient.put<Post>(environment.baseUrl + '/post/update/'+ post.idPost, post);
  }

  downloadPostPDF(postId: number): Observable<HttpResponse<ArrayBuffer>> {
    const url = environment.baseUrl + "/pdf-generator/post/" + postId;
    const headers = new HttpHeaders().set('Accept', 'application/pdf');
    return this.httpClient.get(url, {
      headers: headers,
      observe: 'response',
      responseType: 'arraybuffer'
    });
  }  
}




