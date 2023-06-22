import { Component, OnInit } from '@angular/core';
import { Login } from '../models/Login';
import { SignupService } from '../services/signup.service';
import { Router } from '@angular/router';
import { UploadImage } from 'src/app/features/upload-image/UploadImage';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';
import { environment } from 'src/environments/environment';
import { SignUp } from '../models/SignUp';
import { Account } from '../models/Account';
import { CookieService } from 'ngx-cookie-service';
import { Response } from '../models/Response';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent implements OnInit {
  login = new Login();
  signup = new SignUp();
  response : Response = new Response();
  account : Account = new Account();
  token !: string;
  cookieValue !: string;
  constructor(private signupService: SignupService , private router: Router, private cookieService: CookieService) {}

  ngOnInit(): void {

  }
  submit(): void {

    this.signupService.login(this.login).subscribe({
      next: (data) => {
        this.response = data;
        this.token = this.response.token;
        console.log(this.token);
        this.cookieService.set('jwtToken', this.token);
        this.router.navigateByUrl('/admin');
      },
      error : (error) => {
        if (error.toString() === "403"){
        this.router.navigateByUrl('/singup');
      }
    }
    });
  }
  getaccount():void{
  this.cookieValue = this.cookieService.get('jwtToken');
  console.log(this.cookieValue);
  this.signupService.retrieveaccount(this.cookieValue).subscribe(
    {
      next: (data) => {data
        console.log(data)
      },
      error : (error) => {
        if (error.toString() === "403"){
          this.router.navigateByUrl('/singup');

      }
   }
      
    }
  )
  }
  logout(): void {

    this.signupService.logout().subscribe({
      next: () => {
        this.cookieService.set('jwtToken', '' , 0);
        this.router.navigateByUrl('/singup');
      }
    });
  }
  register(): void {

    this.signupService.register(this.signup ).subscribe(
      {
        next: (data) => {
          console.log(data)
          this.router.navigate(['/admin'])
        }
      }
    )
  }

}
