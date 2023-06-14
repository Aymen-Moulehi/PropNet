import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
  })
  export class FeedbackService {
    constructor(private http: HttpClient) { }


    add(feedback:any){
        return this.http.post<any>("http://localhost:8089/app/feedback/add-feedback/",feedback);
      }
    getALL(){
        return  this.http.get("http://localhost:8089/app/feedback/retrieveAllfeedback");
      }
    delete(id:number){
        return  this.http.delete<any>("http://localhost:8089/app/feedback/delete-feedback/"+id);
      }  
      
    getDetails(id:number){
       return  this.http.get("http://localhost:8089/app/feedback/retrieve-feedback/"+id);
      }
     
      

  }
