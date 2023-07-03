import { Injectable } from '@angular/core';
import { Account } from '../models/Account';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { SignupService } from './signup.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Observable, catchError, throwError } from 'rxjs';
import { UserResetPassword } from '../models/UserResetPassword';

@Injectable({
  providedIn: 'root'
})
export class RestepasswordService {

  constructor(private httpClient: HttpClient ,
    private signupService: SignupService ,
    private router: Router ,
     private cookieService: CookieService) { }

     checkemailandsendcode(resetpassword : UserResetPassword) :Observable<any>{
      return this.httpClient.post<any>(environment.baseUrl + '/appUser/resetpassword', resetpassword );
    }
    resetpassword(resetpassword : UserResetPassword) :Observable<any>{
      return this.httpClient.post<any>(environment.baseUrl + '/appUser/checkpasscode', resetpassword );
    }

}
