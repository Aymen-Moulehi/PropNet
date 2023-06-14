import { Component, OnInit } from '@angular/core';
import { ClaimService } from 'src/app/services/claim.service';

@Component({
  selector: 'app-list-claim',
  templateUrl: './list-claim.component.html',
  styleUrls: ['./list-claim.component.css']
})
export class ListClaimComponent implements OnInit {
  claimList:any=[];
  Total!:number;

  constructor( private claimServices : ClaimService) { }

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
