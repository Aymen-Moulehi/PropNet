import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {Annonce} from '../models/Annonce';
import {City} from '../models/City';
import {Governorate} from '../models/Governorate';
import {FilterAnnonceService} from '../services/filter-annonce.service';

@Component({
  selector: 'app-list-annonces',
  templateUrl: './list-annonces.component.html',
  styleUrls: ['./list-annonces.component.css']
})
export class ListAnnoncesComponent implements OnInit {

  annonces: Annonce[] = [];
  annonce: Annonce = new Annonce();
  city: City = new City();
  governorate: Governorate= new Governorate();
  @ViewChild('ids') ids!: ElementRef;
  @ViewChild('gov') gov!: ElementRef;
  @ViewChild('cit') cit!: ElementRef;
  @ViewChild('nbed') nbed!: ElementRef;
  @ViewChild('nba') nba!: ElementRef;
  @ViewChild('opType') opType!: ElementRef;
  @ViewChild('built') built!: ElementRef;
  @ViewChild('sort') sort!: ElementRef;
  @ViewChild('fnumb') fnumb!: ElementRef;
  propertyType: string[];
  govs: string[];
  cities: string[];
  nbedRooms: string[];
  nbathrooms: string[];
  operationType: string[];
  builtYear: string[];
  sortBy: string[];
  floorNumber: string[];

  constructor(private filterAnnonceService:FilterAnnonceService, private router: Router) {
    this.propertyType = [
      "Choose Property Type","VILLA","APPARTMENT","MAISON","DUPLEX","STUDIO"
    ]
    this.nbedRooms = [
      "Min Bedrooms","1", "2", "3", "4", "5", "6"
    ]
    this.nbathrooms = [
      "Min Bathrooms","1", "2", "3", "4", "5"
    ]
    this.floorNumber = [
      "Floor Number","1", "2", "3", "4", "5","6","7","8","9","10"
    ]
    this.operationType = [
      "Choose Operation Type", "SALE", "RENT"
    ]
    this.builtYear = [
      "Built Year", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"
    ]
    this.govs = [
      "Choose government", "Ariana", "Tunis", "Nabeul", "Hammamet", "Bizerte", "Sfax", "Sousse", "Monastir", "Djerba"
    ]
    this.cities = [
      "Choose city","Manar", "Bardo", "Aouina", "Borj Louzir", "Marsa", "Carthage", "Menzah1"
    ]
    this.sortBy = [
      "Sorting By","Low Price", "High Price"
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
    console.log(this.cit.nativeElement.value);
    if(this.ids.nativeElement.value!="Choose Property Type"){
    this.annonce.propertyType = this.ids.nativeElement.value}
    if(this.cit.nativeElement.value!= "Choose city"){
      this.city.name = this.cit.nativeElement.value}
    console.log(this.city.name);
    if(this.gov.nativeElement.value!="Choose government"){
      this.governorate.name = this.gov.nativeElement.value}
      if(this.nbed.nativeElement.value!="Min Bedrooms"){
    this.annonce.numberOfBedrooms = this.nbed.nativeElement.value}
    if(this.nba.nativeElement.value!="Min Bathrooms"){
      this.annonce.numberOfBathrooms = this.nba.nativeElement.value}
      if(this.fnumb.nativeElement.value!="Floor Number"){
        this.annonce.floorNumber = this.fnumb.nativeElement.value}
    if(this.built.nativeElement.value!="Built Year"){
      this.builtYear = this.built.nativeElement.value}
    if(this.opType.nativeElement.value!="Choose Operation Type"){
      this.annonce.operation = this.opType.nativeElement.value}
    this.annonce.city= this.city;
    this.annonce.governorate = this.governorate;
    console.log(this.annonce);
    console.log(this.annonce.price);
    if(this.sort.nativeElement.value!="Sorting By"){
      this.annonce.orderBy = this.sort.nativeElement.value
    }
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
    console.log("Helloooooo");
  }
  map(){
    console.log(this.annonce.price);
  }
  isWithinThreeMonths(dateParam: Date): boolean {
    const today = new Date();
    const differenceInMonths = (today.getMonth() - dateParam.getMonth()) + (12 * (today.getFullYear() - dateParam.getFullYear()));

    return differenceInMonths < 3;
  }
}
