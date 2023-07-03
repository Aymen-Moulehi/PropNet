import { Component, OnInit } from '@angular/core';
import { RestepasswordService } from '../services/restepassword.service';
import { Router } from '@angular/router';
import { Account } from '../models/Account';
import { Login } from '../models/Login';
import { CookieService } from 'ngx-cookie-service';
import { error } from 'console';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { copyFileSync } from 'fs';
import { UserResetPassword } from '../models/UserResetPassword';


@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
email !: string;
status : boolean = false;
checkPassword !: boolean;
userresetpassword: UserResetPassword = new UserResetPassword();
  constructor(private restepasswordService: RestepasswordService ,private router: Router) { }

  ngOnInit(): void {
  }
  checkemail(): void {
    console.log(this.userresetpassword.email);
    this.restepasswordService.checkemailandsendcode(this.userresetpassword).subscribe({
      next: (data) => {
        this.status=true;
      }

    });
  }
  resetpassword(): void {
    console.log(this.userresetpassword.email);
    console.log(this.userresetpassword.code);
    console.log(this.userresetpassword.newPassword);
    this.restepasswordService.resetpassword(this.userresetpassword).subscribe({
      next: (data) => {
        console.log(data);
        this.router.navigateByUrl('/singup');
      }
    });
  }

}
