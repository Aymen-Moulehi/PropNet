import {Component, OnInit} from '@angular/core';
import {PostService} from 'src/app/services/post.service';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-posts',
  templateUrl: './list-posts.component.html',
  styleUrls: ['./list-posts.component.css']
})
export class ListPostsComponent implements OnInit {

  constructor(private apiService : PostService) { }
  currentPage: number = 1; // Page actuelle
  itemsPerPage: number = 10; // Nombre d'éléments par page
  ListPostsPending: any[] = [];
  countPost:number = 0;
  ngOnInit(): void {
    console.log(this.fetchData())
    this.fetchData()

  }

  deletePost(id: number) {
    Swal.fire({
      title: 'Confirmation',
      text: 'Do you really want to delete this post?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.deletePosts(id).subscribe({
          next: () => {
            Swal.fire('Deleted', 'The post has been deleted successfully', 'success');
            this.fetchData();
          },
          error: (e) => {
            console.error(e);
            Swal.fire('Error', 'An error occurred while deleting the post', 'error');
          }
        });
      }
    });
  }

  fetchData(): void {
    this.apiService.getPosts().subscribe(data => {
      this.countPost = data.length
      console.log(data)
          this.ListPostsPending = data;
       });
      }

      updatePost(post: Post) {
        Swal.fire({
          title: 'Confirmation',
          text: 'Do you really want to accept this post?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Yes',
          cancelButtonText: 'No'
        }).then((result) => {
          if (result.isConfirmed) {
            this.apiService.updatePosts(post).subscribe(updatedPost => {
              Swal.fire('Accepted', 'The post has been accepted successfully', 'success');
              this.fetchData();
            });
          }
        });
      }
      ;

      get totalPages(): number[] {
        return Array(Math.ceil(this.ListPostsPending.length / this.itemsPerPage)).fill(0).map((x, i) => i + 1);
      }

      changePage(page: number): void {
    if (page >= 1 && page <= this.totalPages.length) {
      this.currentPage = page;
    }
  }

  getItemsForCurrentPage(): any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.ListPostsPending.slice(startIndex, endIndex);
  }


}
