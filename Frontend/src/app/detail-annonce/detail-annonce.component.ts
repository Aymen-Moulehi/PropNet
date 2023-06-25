import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StatisticsService } from '../services/statistics.service';
import { FeedbackService } from '../services/feedback.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RealEstateListingService } from '../services/real-estate-listing.service';


@Component({
  selector: 'app-detail-annonce',
  templateUrl: './detail-annonce.component.html',
  styleUrls: ['./detail-annonce.component.css']
})
export class DetailAnnonceComponent implements OnInit {
  itemId!: string;
  annonce : any
  addForm!: FormGroup; 
  feedbackList:any=[];

  constructor(private route: ActivatedRoute,private apiService: RealEstateListingService,private feedbackService : FeedbackService) {
    this.addForm = new FormGroup({
      name: new FormControl('', Validators.required) ,
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") ]),
      description: new FormControl('', Validators.required), 
    });
   }
   get email(){ return this.addForm.get('email')};

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.getAnnonceWithId(id);
    }
    this.getAllFeedback();
  }

  getAllFeedback(){

    this.feedbackService.getALL().subscribe({
      next: (res) => {
        this.feedbackList = res ; 
        //this.router.navigate(['/detail-annonce'])
      },
      error: (e) => console.error(e), 
    }) }

  addFeedback(){
    let data = this.addForm.value; 
    this.feedbackService.add(data).subscribe(
      {
        //next: ()=>{this.router.navigate(['/']);}
      }
     )
     console.log(data)

  }
  
deleteFeedback(id:number){
  if (confirm('Voulez vous vraiment supprime cette Claim !!?')) {
  this.feedbackService.delete(id).subscribe({
    next: () => {
        this.getAllFeedback();
    },
    error: (e) => console.error(e), 
  }) 
}
}

  getAnnonceWithId(id:String): void {
    this.apiService.getRealEstateById(id)
    .subscribe(
      data => {
        this.annonce = data;
        console.log(this.annonce)
      },
      error => {
        console.error(error);
      }
    );
  }


}
