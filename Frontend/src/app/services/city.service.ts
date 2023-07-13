import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient) { }

  Get_city() :Observable<[]>{
    return this.http.get<[]>('http://localhost:8089/app/appUser/countUser');
  }
}
