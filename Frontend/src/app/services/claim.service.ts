import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
  })
  export class ClaimService {
    constructor(private http: HttpClient) { }


    add(claim:any){
        return this.http.post<any>("http://localhost:8089/app/claim/add-claim/",claim);
      }
    getALL(){
        return  this.http.get("http://localhost:8089/app/claim/retrieveAllClaim");
      }
    delete(id:number){
        return  this.http.delete<any>("http://localhost:8089/app/claim/delete-claim/"+id);
     }  
     
  getDetails(id:number){
    return  this.http.get("http://localhost:8089/app/claim/retrieve-claim/"+id);
  }
     
      

  }
