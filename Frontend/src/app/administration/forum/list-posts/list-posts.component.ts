import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';

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

  ngOnInit(): void {
    this.fetchData()

  }



  deletePost(id:number){
    if (confirm('Voulez vous vraiment supprime cette poste !!?')) {
    this.apiService.deletePosts(id).subscribe({
      next: () => {
        this.fetchData(); 
      },
      error: (e) => console.error(e), 
    }) 
  }
  }


  fetchData(): void {
    this.apiService.getPosts().subscribe(data => {
      console.log(data)
          this.ListPostsPending = data;
       });
      }

      updatePost(post: Post) {
        if (confirm('Voulez vous vraiment de accepter cette poste !!?')) {
          this.apiService.updatePosts(post).subscribe(updatedPost => {
            this.fetchData()
        })
        }
   };
      
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
