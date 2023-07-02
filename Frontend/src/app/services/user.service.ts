import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient) { }

  getCountUser() :Observable<[]>{
    return this.http.get<[]>('http://localhost:8089/app/appUser/countUser');
  }

  getUsers() {
    return this.http.get<[]>(environment.baseUrl + '/appUser/users');
  }
  deleteUser(id: number) {
    return this.http.delete<any>(environment.baseUrl + '/appUser/delete/'+ id);
  }
  activateAccount(user:User) {
    return this.http.put<User>(environment.baseUrl + '/appUser/account/activate/'+ user.idAppUser, user);
  }
  deactivateAccount(user:User) {
    return this.http.put<User>(environment.baseUrl + '/appUser/account/deactivate/'+ user.idAppUser, user);
  }
  getUserByNameAndAccountStatus(name:string,status: string) {
    return this.http.get<[]>(environment.baseUrl + '/appUser/name/' + name + '/status/' + status);

  }
  

}
