import { Component, OnInit } from '@angular/core';
import { RealEstateListingService } from 'src/app/services/real-estate-listing.service';
import { StatisticsService } from 'src/app/services/statistics.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-annonce',
  templateUrl: './list-annonce.component.html',
  styleUrls: ['./list-annonce.component.css']
})
export class ListAnnonceComponent implements OnInit {

   listAnnonce: any[] = [];
   currentPage: number = 1; // Page actuelle
   itemsPerPage: number = 10; // Nombre d'éléments par page
   selectedPropertyType!: string;
   countAnnonce: number = 0;


  constructor(private apiService : RealEstateListingService) { }

  ngOnInit(): void {

    this.fetchData()

  }

 

  fetchData(): void {
    this.apiService.getRealEstatePending().subscribe(data => {
         this.countAnnonce = data.length
          this.listAnnonce = data;
       });
      }

      get totalPages(): number[] {
        return Array(Math.ceil(this.listAnnonce.length / this.itemsPerPage)).fill(0).map((x, i) => i + 1);
      }

      changePage(page: number): void {
    if (page >= 1 && page <= this.totalPages.length) {
      this.currentPage = page;
    }
  }
    
  getItemsForCurrentPage(): any[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.listAnnonce.slice(startIndex, endIndex);
  }

  deleteAnnonce(id: number) {
    Swal.fire({
      title: 'Confirmation',
      text: 'Do you really want to delete this announcement?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.deleteRealEstate(id).subscribe({
          next: () => {
            Swal.fire('Deleted', 'The announcement has been deleted successfully', 'success');
            this.fetchData();
          },
          error: (e) => {
            console.error(e);
            Swal.fire('Error', 'An error occurred while deleting the announcement', 'error');
          }
        });
      }
    });
  }
  

accepteAnnonce(realEstate: any) {
  Swal.fire({
    title: 'Confirmation',
    text: 'Do you really want to accept this advertisement?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Yes',
    cancelButtonText: 'No'
  }).then((result) => {
    if (result.isConfirmed) {
      this.apiService.getRealEstateByIdToAccepted(realEstate).subscribe(activate => {
        Swal.fire('Accepted', 'The advertisement has been accepted successfully', 'success');
        this.fetchData();
      });
    }
  });
}



}
