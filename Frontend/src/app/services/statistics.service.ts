import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {


  constructor(private http: HttpClient) { }

  userPostwithLocation() :Observable<[]>{
    return this.http.get<[]>('http://localhost:8089/app/appUser/user-post-withLocation');
  }
  getUsersByRegion() :Observable<[]>{
    return this.http.get<[]>('http://localhost:8089/app/appUser/user-by-region');
  }
  getAdvertisement(){
    return this.http.get<any[]>('https://jsonplaceholder.typicode.com/posts');
  }
  getAdvertisementWithId(id : String) {
    let apiUrl = 'https://jsonplaceholder.typicode.com/posts'; // Replace with your API endpoint
    const url = `${apiUrl}/${id}`;
    return this.http.get<any>(url);
  }

}
