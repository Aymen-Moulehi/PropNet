import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, NgModel } from '@angular/forms';
import { RealEstateStatus } from '../models/RealEstateStatus';
import { CityService } from '../services/city.service';
import { GovernorateService } from '../services/governorate.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Governorate } from '../models/Governorate';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { RealEstateListing } from '../models/RealEstateListing';
import { City } from '../models/City';
import { UploadImage } from '../features/UploadImage';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.css']
})
export class AddAnnonceComponent implements OnInit {
  _realestatelisting: RealEstateListing = new RealEstateListing();
  ListCity : City[] =[]
  // ListGouvernorate : any[] =[];
  ListGouvernorate : Governorate[] = [];
  newgovernorate: Governorate = new Governorate() ;
  newcity: City = new City() ; // or Governorate type
  autoincrm : number = 3 ;
  currentDate: Date = new Date();
  uploadedImage!: File;
  // 


   // Initialize the object
  @ViewChild('operation') operation!: ElementRef;
  @ViewChild('propertyType') propertyType!: ElementRef;

  

  
  realEstateStatusValues: string[] = Object.values(RealEstateStatus);
  constructor(private cityService:CityService , private gouvernorateService:GovernorateService, private http:HttpClient, private uploadImage: UploadImage, private _router:Router) { }
  



  ngOnInit(): void {   
    this.getCountries();

  }

  getCountries(){
    this.gouvernorateService.Get_governorate().subscribe(data => this.ListGouvernorate = data);
    console.log(this.ListGouvernorate);

  }

  getCities(){
    this.gouvernorateService.Get_Cities_by_gov(this.newgovernorate.idGovernorate).subscribe(data => this.ListCity = data);
    console.log(this.newgovernorate.idGovernorate);
  }

  public onImageUpload(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    console.log(files);
    this.uploadedImage = files[0];
  }

  public imageUploadAction() {
    // The return of this method is a string contain the URL to the image
    this.uploadImage.imageUploadAction(this.uploadedImage).subscribe(
      {
        next : (data) => console.log(data),
        error : (error) => console.log(error),
        complete : () => console.log("done")
      }
     )
  }



  onSubmit() {
    const selectedOperation = this.operation.nativeElement.value;
    const selectedPropertyType = this.propertyType.nativeElement.value;
    console.log(selectedOperation);
    console.log(selectedPropertyType);
    // Assign the selected values to the realEstateListing object
    this._realestatelisting.governorate = this.newgovernorate;
    this._realestatelisting.city = this.newcity;
    this._realestatelisting.operation = selectedOperation;
    this._realestatelisting.propertyType = selectedPropertyType;
    this._realestatelisting.idRealEstateListing = this.autoincrm++;
    this._realestatelisting.creationDate = this.currentDate;
    this._realestatelisting.realEstateIsSold = false;
    this._realestatelisting.realEstateStatus = "PENDING";
    console.log(this.ListCity);
    console.log(this.ListGouvernorate);
    // this.imageUploadAction();

      this.http.post('http://localhost:8089/app/realEstateListing/add-realEstateListing', this._realestatelisting).subscribe(
      (response) => {
        console.log('Listing added successfully', response);
        this._router.navigate(['/postAdded']);

      },
      (error) => {

        console.error('Error adding listing', error);
        console.log(this._realestatelisting);
        // Handle error response
      }
    );
  
  }






  }




