import { Injectable } from '@angular/core';
import { Account } from '../models/Account';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { SignupService } from './signup.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateAccountService {
  cookieValue !: string;

  constructor(private httpClient: HttpClient ,
    private signupService: SignupService ,
    private router: Router ,
     private cookieService: CookieService) { }



  update(account : any) :Observable<any>{
    const httpOptions = {
      withCredentials: true
            };

    return this.httpClient.post<any>(environment.baseUrl + '/appUser/update', account , httpOptions);
  }

  private handleError(error: HttpErrorResponse) {
    let stat: string
   if (error.status === 0) {
     // A client-side or network error occurred. Handle it accordingly.
     console.error('An error occurred:', error.error);
   } else {
     // The backend returned an unsuccessful response code.
     // The response body may contain clues as to what went wrong.
     console.error(
       `Backend returned code ${error.status}, body was: `, error.error);
       stat = error.status.toString();
   }
   // Return an observable with a user-facing error message.
   return throwError(() => stat);
 }
}
