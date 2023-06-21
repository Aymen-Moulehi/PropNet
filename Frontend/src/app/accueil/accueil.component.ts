import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Annonce } from '../models/Annonce';
import { FilterAnnonceService } from '../services/filter-annonce.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  annonces: Annonce[] = [];
  annonce: Annonce = new Annonce(); 
  @ViewChild('ids') ids!: ElementRef;
  @ViewChild('gov') gov!: ElementRef;
  @ViewChild('cit') cit!: ElementRef;
  @ViewChild('nbed') nbed!: ElementRef;
  @ViewChild('opType') opType!: ElementRef;
  propertyType: string[];
  governorate: string[];
  city: string[];
  nbedRooms: string[];
  operationType: string[];
  
  constructor(private filterAnnonceService:FilterAnnonceService, private router: Router) {
    this.propertyType = [
      "VILLA","APPARTMENT","MAISON","DUPLEX","STUDIO"
    ]
    this.governorate = [
      "Ariana", "Tunis", "Nabeul", "Hammamet", "Bizerte", "Sfax", "Sousse", "Monastir", "Djerba"
    ]
    this.city = [
      "Manar", "Soukra", "Aouina", "Borj Louzir", "Marsa", "Carthage", "Menzah"
    ]
    this.nbedRooms = [
      "1", "2", "3", "4","5"
    ]
    this.operationType = [
      "SALE", "RENT"
    ]
  }
 
  ngOnInit(): void {
     this.filterAnnonceService.getAnnonces().subscribe(
      {
        next: (data) => {
          console.log(data);
           this.annonces = data},
        error: (error) => { console.log(error)},
        complete: () => { console.log('done') }    
      }
    ); 
  
  }
  search(): void { 
    this.annonce.propertyType = this.ids.nativeElement.value
    this.annonce.city = this.cit.nativeElement.value
    this.annonce.governorate = this.gov.nativeElement.value
    this.annonce.numberOfBedrooms = this.nbed.nativeElement.value
    this.annonce.operation = this.opType.nativeElement.value
    this.annonces = []

    this.filterAnnonceService.filterAnnonces(this.annonce).subscribe(
      {
        next: (data) => {
          console.log(data);
          this.annonces=data;
        },
        error: (error) => { console.log(error)},
        complete: () => { console.log('done') }    
      }
    )
   }
   onSelected(){
    console.log("Moataz");
  }


  }

 


