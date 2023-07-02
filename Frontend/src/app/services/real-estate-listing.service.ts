import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RealEstateListingService {


  constructor(private htttpClient:HttpClient) { }

 
    getRealEstateAccepted(){
      return this.htttpClient.get<any[]>(environment.baseUrl + '/realEstateListing/accepted');
    }
    getRealEstatePending(){
      return this.htttpClient.get<any[]>(environment.baseUrl + '/realEstateListing/pending');
    }
    getRealEstateById(id:String){
      return this.htttpClient.get<any[]>(environment.baseUrl + '/realEstateListing/'+id);
    }
    getRealEstateByIdToAccepted(realEstate:any){
      return this.htttpClient.put<any>(environment.baseUrl + '/realEstateListing/accepted/'+realEstate.idRealEstateListing,realEstate);
    }

    deleteRealEstate(id: number) {
      return this.htttpClient.delete<any>(environment.baseUrl + '/realEstateListing/delete/'+ id);
    }
}
