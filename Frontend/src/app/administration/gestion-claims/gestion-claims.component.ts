import { Component, OnInit } from '@angular/core';
import { ClaimServicesService } from 'src/app/services/claim-services.service';

@Component({
  selector: 'app-gestion-claims',
  templateUrl: './gestion-claims.component.html',
  styleUrls: ['./gestion-claims.component.css']
})
export class GestionClaimsComponent implements OnInit {
  ClaimList:any=[];
  constructor( private claimServices : ClaimServicesService) { }

  ngOnInit(): void {
    this.GetAllClaims();
  }
  
GetAllClaims(){
  this.claimServices.getALL().subscribe
  ({
    next:(res) => {
      this.ClaimList=res ;},
    error:(e)=>console.error(e),
  }
  )}



DeleteClaim(ID:number){
  if(confirm('Voulez vous vraiment supprime cette Claims ?')){
    this.claimServices.delete(ID).subscribe({
      next:()=>{this.GetAllClaims;},
      error:(e)=>console.error(e),})

  }
}



}
