import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Annonce } from '../models/Annonce';

@Injectable({
  providedIn: 'root'
})
export class FilterAnnonceService {

  constructor(private httpClient: HttpClient) { }

  getAnnonces() {
    return this.httpClient.get<Annonce[]>(environment.baseUrl + '/realEstateListing/retrieve-all-RealEstateListings/');
   }
   filterAnnonces(annonce: Annonce) {
    return this.httpClient.post<Annonce[]>(environment.baseUrl + '/realEstateListing/filter', annonce);
  }
}
