import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UploadImage } from 'src/app/features/upload-image/UploadImage';
import { User } from 'src/app/models/User';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  currentPage: number = 1; // Page actuelle
  itemsPerPage: number = 10; // Nombre d'éléments par page
  ListUsers: any[] = [];


  constructor(private apiService : UserService,private uploadImage: UploadImage) { }

  ngOnInit(): void {
    this.fetchData()
  }

  fetchData(): void {
    this.apiService.getUsers().subscribe(data => {
          this.ListUsers = data;
       });
      }

      get totalPages(): number[] {
        return Array(Math.ceil(this.ListUsers.length / this.itemsPerPage)).fill(0).map((x, i) => i + 1);
      }
      changePage(page: number): void {
        if (page >= 1 && page <= this.totalPages.length) {
          this.currentPage = page;
        }
      }
      getItemsForCurrentPage(): any[] {
        const startIndex = (this.currentPage - 1) * this.itemsPerPage;
        const endIndex = startIndex + this.itemsPerPage;
        return this.ListUsers.slice(startIndex, endIndex);
      }

      deletePost(id:number){
        if (confirm('Voulez vous vraiment supprime cette User !!?')) {
        this.apiService.deleteUser(id).subscribe({
          next: () => {
            this.fetchData(); 
          },
          error: (e) => console.error(e), 
        }) 
      }
      }

      activateAccount(user: User) {
        if (confirm('Do you really want to activate this account !!?')) {
          this.apiService.activateAccount(user).subscribe(activate => {
            this.fetchData()
        })
        }
   };
   
   deactivateAccount(user: User) {
    if (confirm('Do you really want to deactivate this account !!?')) {
      this.apiService.deactivateAccount(user).subscribe(deactivate => {
        this.fetchData()
    })
    }
};



}
