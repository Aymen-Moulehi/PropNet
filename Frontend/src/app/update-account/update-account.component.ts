import { Component, OnInit } from '@angular/core';
import { Login } from '../models/Login';
import { SignUp } from '../models/SignUp';
import { UpdateAccountService } from '../services/update-account.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Account } from '../models/Account';
import { SignupService } from '../services/signup.service';
import { nextTick } from 'process';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {
  login = new Login();
  account = new Account();
  cookieValue !: string;
  signup = new SignUp();
  tokenAv !: Boolean;

  constructor(private updateservice: UpdateAccountService ,private signupService: SignupService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {

    this.signupService.isTokenAv(this.cookieValue).subscribe(
      {

        next: (data) => { this.tokenAv = data
          console.log(data)
          if (this.tokenAv){
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

  update() : void{
    this.cookieValue = this.cookieService.get('jwtToken');
    this.updateservice.update(this.account).subscribe(
      {

          next: (data) => {this.account=data
            console.log(data)
            this.router.navigateByUrl('/singup');

          },
          error : (error) => {console.log('erroeee' , error)
        }


      }
    )
  }

}
