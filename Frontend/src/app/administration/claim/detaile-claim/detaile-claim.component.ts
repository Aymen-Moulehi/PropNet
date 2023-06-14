import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ClaimService } from 'src/app/services/claim.service';

@Component({
  selector: 'app-detaile-claim',
  templateUrl: './detaile-claim.component.html',
  styleUrls: ['./detaile-claim.component.css']
})
export class DetaileClaimComponent implements OnInit {

  addForm!: FormGroup; 
  idClaim!:number; 
  cont:any={};
  constructor( private claimServices : ClaimService, private router: Router,
  private activateRoute: ActivatedRoute) {

  this.addForm = new FormGroup({
    name: new FormControl('', Validators.required) ,
    email: new FormControl('', Validators.required) ,
    sujet: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required)
  });
  this.idClaim = parseInt(this.activateRoute.snapshot.paramMap.get('id')!); 

  this.claimServices.getDetails(this.idClaim).subscribe({
    next: (res) => {
      this.cont = res ; 
    },
    error: (e) => console.error(e), 
  }) 
}
ngOnInit(): void {
}

}
