import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, NgModel } from '@angular/forms';
import { RealEstateStatus } from '../models/RealEstateStatus';
import { CityService } from '../services/city.service';
import { GovernorateService } from '../services/governorate.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Governorate } from '../models/Governorate';


@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.css']
})
export class AddAnnonceComponent implements OnInit {
  realEstateListing: any;
  ListCity : any[] =[]
  ListGouvernorate! : ["fhewuhf", "test1"];
  // ListGouvernorate : any[] = ['test1', 'test2'];
  newgovernorate!: any; // or Governorate type
  autoincrm : number = 1
  currentDate: Date = new Date();


   // Initialize the object
  // @ViewChild('gouvernorate') gouvernorate!: ElementRef;
  @ViewChild('city') city!: ElementRef;
  @ViewChild('operation') operation!: ElementRef;
  @ViewChild('propertyType') propertyType!: ElementRef;

  

  
  realEstateStatusValues: string[] = Object.values(RealEstateStatus);
  constructor(private cityService:CityService , private gouvernorateService:GovernorateService ) { }



  ngOnInit(): void {
    // this.f();
    // this.gouvernorateService.Get_governorate().subscribe({
      // next:(data) => {this.ListGouvernorate = data;    
    //  (data) => this.ListGouvernorate ;    
    //this.gouvernorateService.Get_governorate().subscribe(data => this.ListGouvernorate = data);
      // error: (e) => console.error(e),
      
    // })
    console.log(this.ListGouvernorate);
  }

  // f() {
    
  //   console.log(this.ListGouvernorate);
  // }

  // onSubmit() {
  //   // const selectedGovernorate = this.governorate.nativeElement.value;
  //   // const selectedCity = this.city.nativeElement.value;
  //   const selectedOperation = this.operation.nativeElement.value;
  //   const selectedPropertyType = this.propertyType.nativeElement.value;

  
  //   // Assign the selected values to the realEstateListing object
  //   // this.realEstateListing.governorate = selectedGovernorate;
  //   // this.realEstateListing.city = selectedCity;
  //   // this.realEstateListing.operation = selectedOperation;
  //   // this.realEstateListing.propertyType = selectedPropertyType;
  //   // this.realEstateListing.idRealEstateListing = this.autoincrm++;
  //   // this.realEstateListing.creationDate = this.currentDate;
  //   // this.realEstateListing.realEstateIsSold = false;
  //   // this.realEstateListing.realEstateStatus = "PENDING";
  //   console.log(this.realEstateListing);

  //     this.http.post('http://localhost:8089/app/realEstateListing/add-realEstateListing', this.realEstateListing).subscribe(
  //     (response) => {
  //       console.log('Listing added successfully', response);
  //       // Handle success response
  //     },
  //     (error) => {

  //       console.error('Error adding listing', error);
  //       // Handle error response
  //     }
  //   );
  
  // }






  }




