import { Component, OnInit } from '@angular/core';
import { StatisticsService } from 'src/app/services/statistics.service';

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

 


  constructor(private apiService : StatisticsService) { }

  ngOnInit(): void {

    this.fetchData()

  }

 

  fetchData(): void {
    this.apiService.getAdvertisement().subscribe(data => {
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

}
