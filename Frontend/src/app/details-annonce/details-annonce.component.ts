import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { FeedbackServicesService } from '../services/feedback-services.service';
import { RealEstateListingService } from '../services/real-estate-listing.service';

@Component({
  selector: 'app-details-annonce',
  templateUrl: './details-annonce.component.html',
  styleUrls: ['./details-annonce.component.css']
})
export class DetailsAnnonceComponent implements OnInit {
  itemId!: string;
  annonce : any
  addForm!: FormGroup;
  feedbackList:any=[];

  constructor(private route: ActivatedRoute,private apiService: RealEstateListingService,private feedbackService : FeedbackServicesService) {
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
