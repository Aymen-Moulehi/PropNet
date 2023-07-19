import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClaimServicesService } from '../services/claim-services.service';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {
  addFroms!: FormGroup;
  constructor( private claimServices : ClaimServicesService,
    private rout:Router ){
      this.addFroms = new FormGroup({
      name: new FormControl('', Validators.required) ,
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") ]),
      subject: new FormControl('', Validators.required),
      message: new FormControl('', Validators.required),
    });

  }
  get email(){ return this.addFroms.get('email')};

  ngOnInit(): void {
  }

  addClaims(){
    let res = this.addFroms.value;
    this.claimServices.add(res).subscribe(
      {
        
        next: ()=>{this.rout.navigate(['/']);
        alert("Claim added successfully  , please check your email !!")

      }
      }
    )
  }

}



