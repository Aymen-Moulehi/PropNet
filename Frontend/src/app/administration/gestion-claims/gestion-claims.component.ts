import { Router } from '@angular/router';
 import { Component, OnInit } from '@angular/core';
import { ClaimServicesService } from 'src/app/services/claim-services.service';

 @Component({
  selector: 'app-gestion-claims',
  templateUrl: './gestion-claims.component.html',
  styleUrls: ['./gestion-claims.component.css']
} )
export class GestionClaimsComponent implements OnInit {
  ClaimList:any=[];
  claim:  any;
  selectedClaim: any;
  id!:number;
  
  constructor( private claimServices : ClaimServicesService , private router: Router ) { }

   ngOnInit(): void {
     this.GetAllClaims();
   }
  
  
   updateClaim(claim: any) {
    this.router.navigate(['admin/update-claim']);
  }

GetAllClaims(){
  this.claimServices.getALL().subscribe
  ({
    next:(res)=> {
      this.ClaimList=res ;},
    error: (e)=>console.error(e),

   }
  )}



DeleteClaim(ID:number){
  if(confirm('Voulez vous vraiment supprime cette Claims ?')){
    this.claimServices.delete(ID).subscribe({
      next:()=>{this.GetAllClaims;},
      error:(e)=>console.error(e),})
  }
  }}
