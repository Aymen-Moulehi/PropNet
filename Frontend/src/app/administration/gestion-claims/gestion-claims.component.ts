import { Component, OnInit } from '@angular/core';
import { ClaimServicesService } from 'src/app/services/claim-services.service';

@Component({
  selector: 'app-gestion-claims',
  templateUrl: './gestion-claims.component.html',
  styleUrls: ['./gestion-claims.component.css']
})
export class GestionClaimsComponent implements OnInit {
  claimList:any=[];
  Total!:number;
  constructor( private claimServices : ClaimServicesService) { }

  ngOnInit(): void {
    this.getAllClaim();
  }
  getAllClaim(){
    this.claimServices.getALL().subscribe({
      next: (res) => {
        this.claimList = res ;
      },
      error: (e) => console.error(e),
    })
}

deleteClaim(id:number){
  if (confirm('Voulez vous vraiment supprime cette Claim !!?')) {
  this.claimServices.delete(id).subscribe({
    next: () => {
        this.getAllClaim();
    },
    error: (e) => console.error(e),
  })
}
}

totalalArticle(){
  this.Total=0;
 this.Total =this.claimList.length;
 return this.Total;

}

}
