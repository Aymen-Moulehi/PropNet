import { HttpClient } from '@angular/common/http';
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
}
