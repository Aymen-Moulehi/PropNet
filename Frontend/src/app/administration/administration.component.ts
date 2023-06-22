import { Component, OnInit } from '@angular/core';
import { SignupService } from '../services/signup.service';
import { Router } from '@angular/router';
import { Account } from '../models/Account';
import { Login } from '../models/Login';
import { CookieService } from 'ngx-cookie-service';
import { error } from 'console';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
})
export class AdministrationComponent implements OnInit {
  account : Account = new Account();
  login = new Login();
  cookieValue !: string;
  tokenAv !: Boolean;
  response !: HttpResponse<String>;

  constructor(private signupService: SignupService , private router: Router , private cookieService: CookieService  ) { }

  ngOnInit(): void 
 
  {
    this.signupService.isTokenAv(this.cookieValue).subscribe(
      {
        next: (data) => { this.tokenAv = data
          console.log(data)
          if (this.tokenAv){
            console.log()
            this.cookieValue = this.cookieService.get('jwtToken');
          console.log(this.cookieValue);
          this.signupService.retrieveaccount(this.cookieValue).subscribe(
            {
              next: (data) => {this.account=data
                console.log(data)
              },
              error : (error) => {console.log('erroeee' , error)
            }

            }
            
          ) }
          else{
            this.router.navigateByUrl('/singup');
         }
        },
        
      }
    )

    

  }
  chercher() : void {
  }
  logout(): void {

    this.signupService.logout().subscribe({
      next: () => {
        this.cookieService.set('jwtToken', '' , 0);
        this.router.navigateByUrl('/singup');
      }
    });
  }
  

}
