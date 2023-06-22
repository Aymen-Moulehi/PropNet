import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Login } from '../models/Login';
import { SignUp } from '../models/SignUp';
import { Account } from '../models/Account';
import { Observable } from 'rxjs/internal/Observable';
import { CookieService } from 'ngx-cookie-service';
import { catchError, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SignupService {
 private token !: string
 cookieValue !: string;
  constructor(private httpClient: HttpClient , private cookieService: CookieService) {
    
}
  login(login: Login , withCredentials: boolean = false):Observable<any> {
    const requestOptions: any = {
      withCredentials: withCredentials
    };
    this.httpClient.post<Login>(environment.baseUrl + '/appUser/login', login , requestOptions);

    return this.httpClient.post<Login>(environment.baseUrl + '/appUser/login', login , requestOptions).pipe(catchError(this.handleError));
  }
  register(signup : SignUp){
    return this.httpClient.post<SignUp>(environment.baseUrl + '/appUser/register', signup );
  }
  logout(){
    this.cookieValue = this.cookieService.get('jwtToken');
    const httpOptions = {
      withCredentials: true
    };  
    console.log("cookie from logout ----", this.cookieValue);
    const requestOptions: any = {
      headers: {
        'Authorization': `Bearer ${this.cookieValue}`
      }
    };
    return this.httpClient.post(
      environment.baseUrl + '/appUser/logout',
      this.token,
      httpOptions
    );
  }
  retrieveaccount(token: string) {
    
    this.cookieValue = this.cookieService.get('jwtToken');
    const httpOptions = {
      withCredentials: true
    };  
    console.log("cookie from service ----", this.cookieValue);
  
    const requestOptions: any = {
      headers: {
        'Authorization': `Bearer ${this.cookieValue}`
      }
    };
  
    return this.httpClient.post<Account>(
      environment.baseUrl + '/appUser/getAccount',
      this.token,
      httpOptions
    );
  }
  isTokenAv(token: string) {
    
    this.cookieValue = this.cookieService.get('jwtToken');
    const httpOptions = {
      withCredentials: true
    };  
    console.log("cookie from av ----", this.cookieValue);
  
    const requestOptions: any = {
      headers: {
        'Authorization': `Bearer ${this.cookieValue}`
      }
    };
  
    return this.httpClient.post<Boolean>(
      environment.baseUrl + '/appUser/isTokenAv',
      this.token,
      httpOptions
    ).pipe(catchError(this.handleError));
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
