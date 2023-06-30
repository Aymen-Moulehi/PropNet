import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgModel } from '@angular/forms';
import { RealEstateStatus } from '../models/RealEstateStatus';
import { RealEstateListing } from '../models/RealEstateListing';
import { CityService } from '../services/city.service';
import { GovernorateService } from '../services/governorate.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.css']
})
export class AddAnnonceComponent implements OnInit {
  realEstateListing: RealEstateListing = new RealEstateListing();
  ListCity : any[] =[]
  ListGouvernorate :any[] =[];
  newgovernorate!: any; // or Governorate type

   // Initialize the object
  @ViewChild('governorate') governorate!: ElementRef;
  @ViewChild('city') city!: ElementRef;
  @ViewChild('operation') operation!: ElementRef;
  @ViewChild('propertyType') propertyType!: ElementRef;

  

  
  realEstateStatusValues: string[] = Object.values(RealEstateStatus);
  constructor(private cityService:CityService , private gouvernorateService:GovernorateService,private http:HttpClient ) { }
  fetchData(): void {
    this.cityService.Get_city().subscribe(data => {
      this.ListCity = data;
    });
    this.gouvernorateService.Get_governorate().subscribe(data => {
      this.ListGouvernorate = data;
    });
  }
  ngOnInit(): void {
    console.log(this.fetchData());
    console.log(this.ListCity)
  }

  onSubmit() {
    const selectedGovernorate = this.governorate.nativeElement.value;
    const selectedCity = this.city.nativeElement.value;
    const selectedOperation = this.operation.nativeElement.value;
    const selectedPropertyType = this.propertyType.nativeElement.value;

  
    // Assign the selected values to the realEstateListing object
    this.realEstateListing.governorate = selectedGovernorate;
    this.realEstateListing.city = selectedCity;
    this.realEstateListing.operation = selectedOperation;
    this.realEstateListing.propertyType = selectedPropertyType;

        this.http.post('http://localhost:8089/app/realEstateListing/add-realEstateListing', this.realEstateListing).subscribe(
      (response) => {
        console.log('Listing added successfully', response);
        // Handle success response
      },
      (error) => {
        console.error('Error adding listing', error);
        // Handle error response
      }
    );
  
  }






  }




