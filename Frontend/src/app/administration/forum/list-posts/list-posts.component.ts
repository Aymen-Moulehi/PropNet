import {Component, OnInit} from '@angular/core';
import {PostService} from 'src/app/services/post.service';

@Component({
  selector: 'app-list-posts',
  templateUrl: './list-posts.component.html',
  styleUrls: ['./list-posts.component.css']
})
export class ListPostsComponent implements OnInit {

  constructor(private apiService : PostService) { }
  listAnnonce: any[] = [];
  currentPage: number = 1; // Page actuelle
  itemsPerPage: number = 10; // Nombre d'éléments par page
  ListPostsPending: any[] = [];

  ngOnInit(): void {
    console.log(this.fetchData())
    this.fetchData()

  }

  deletePost(id: number) {
    this.apiService.deletePosts(id).subscribe(() => {
      this.fetchData();
    });
  }

  fetchData(): void {
    this.apiService.getPostsPending().subscribe(data => {
          this.ListPostsPending = data;
       });
      }

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
