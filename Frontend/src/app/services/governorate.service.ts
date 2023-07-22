import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GovernorateService {

  constructor(private http: HttpClient) { }

  Get_governorate() {
    return this.http.get<[]>('http://localhost:8089/app/governorate/retrieve-all-governorates');

  }

  Get_Cities_by_gov(id : number) {
    const options = id ? { params: new HttpParams().set('gov-id', id) } : {};
    return this.http.get<[]>('http://localhost:8089/app/region/retrieve-city-by-gov-id/', options);
  }
}
