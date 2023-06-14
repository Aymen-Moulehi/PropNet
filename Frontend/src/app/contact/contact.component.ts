import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClaimService } from '../services/claim.service';


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  addForm!: FormGroup; 
  constructor( private claimServices : ClaimService,
    private router:Router ){
      this.addForm = new FormGroup({
      name: new FormControl('', Validators.required) ,
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") ]),
      sujet: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required), 
    });
  
  }
  get email(){ return this.addForm.get('email')};

  ngOnInit(): void {
  }


  addClaim(){
    let data = this.addForm.value; 

    this.claimServices.add(data).subscribe(
      {
        next: ()=>{this.router.navigate(['/']);}
      }
     )
     console.log(data)
  }

}
