import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StatisticsService } from '../services/statistics.service';


@Component({
  selector: 'app-detail-annonce',
  templateUrl: './detail-annonce.component.html',
  styleUrls: ['./detail-annonce.component.css']
})
export class DetailAnnonceComponent implements OnInit {
  itemId!: string;
  annonce : any

  constructor(private route: ActivatedRoute,private apiService: StatisticsService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.getAnnonceWithId(id);
    }
    
  }

  getAnnonceWithId(id:String): void {
    this.apiService.getAdvertisementWithId(id)
    .subscribe(
      data => {
        this.annonce = data;
        console.log(this.annonce)
      },
      error => {
        console.error(error);
      }
    );
  }


}
