import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UploadImage } from 'src/app/features/upload-image/UploadImage';
import { User } from 'src/app/models/User';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  currentPage: number = 1; // Page actuelle
  itemsPerPage: number = 10; // Nombre d'éléments par page
  ListUsers: any[] = [];
  selectedValue: string = 'USERS';
  filteredUsers: any[] = [];
  selectedValueName!: string;
  constructor(private apiService: UserService, private uploadImage: UploadImage) { }

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    this.apiService.getUsers().subscribe(data => {
      this.filteredUsers = data;
      this.ListUsers = data;
      this.filterUsers(); // Add this line to filter users initially
    });
  }

  get totalPages(): number[] {
    return Array(Math.ceil(this.filteredUsers.length / this.itemsPerPage)).fill(0).map((x, i) => i + 1);
  }

  changePage(page: number): void {
    if (page >= 1 && page <= this.totalPages.length) {
      this.currentPage = page;
    }
  }

  getItemsForCurrentPage(): any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.filteredUsers.slice(startIndex, endIndex);
  }

  deleteUser(id: number) {
    Swal.fire({
      title: 'Confirmation',
      text: 'Do you really want to delete this user?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.deleteUser(id).subscribe({
          next: () => {
            Swal.fire('Deleted', 'The user has been deleted successfully', 'success');
            this.fetchData();
          },
          error: (e) => {
            console.error(e);
            Swal.fire('Error', 'An error occurred while deleting the user', 'error');
          }
        });
      }
    });
  }
  
  
  activateAccount(user: User) {
    Swal.fire({
      title: 'Confirmation',
      text: 'Do you really want to activate this account?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.activateAccount(user).subscribe(activate => {
          Swal.fire('Activated', 'The account has been activated successfully', 'success');
          this.fetchData();
        });
      }
    });
  }
  

  deactivateAccount(user: User) {
    Swal.fire({
      title: 'Confirmation',
      text: 'Do you really want to deactivate this account?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.deactivateAccount(user).subscribe(deactivate => {
          Swal.fire('Deactivated', 'The account has been deactivated successfully', 'success');
          this.fetchData();
        });
      }
    });
  }
  

  searchUsers() {
    this.filterUsers();
  }



  filterUsers(){
    if (this.selectedValue === 'USERS')
    {
      this.filteredUsers = this.ListUsers.slice(); // Use ListUsers for All Users option
    } 
    else if (this.selectedValue && this.selectedValueName) {
      this.apiService.getUserByNameAndAccountStatus(this.selectedValueName, this.selectedValue).subscribe(data => {
        this.filteredUsers = data;
      });
}
}
}
