import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Chart,registerables, ChartOptions } from 'chart.js';
import { PostService } from 'src/app/services/post.service';
import { RealEstateListingService } from 'src/app/services/real-estate-listing.service';
import { StatisticsService } from 'src/app/services/statistics.service';
import { UserService } from 'src/app/services/user.service';
Chart.register(...registerables)

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  chartData: any[]= [];
  ListUsersByRegion : any [] = [];
  CountUsers : any [] = [];
  ListPostsPending!: any;
  countPostPending!: any;
  countPostAnnoncePending!:any;


  constructor(private apiService: StatisticsService,private apiServiceUser : UserService,private apiServicePost : PostService,private apiServiceRealState: RealEstateListingService) { }

  ngOnInit(): void {
    this.fetchData();
  }
  chartOptions: ChartOptions = {
    responsive: true,
    scales: {
      y: {
        beginAtZero: true,
        ticks: {
          callback: (value) => {
            const numericValue = Number(value);
            if (Number.isInteger(numericValue)) {
              return numericValue.toString();
            }else{
              return ""
            } 
          },
        },
      },
    },
  };
  

createChart() {
  const labels = this.chartData.map(data => data.key);
  const values = this.chartData.map(data => data.value);
  new Chart("myChart1", {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [
        {
          label: 'Post with Location',
          data: values,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(255, 159, 64, 0.2)',
            'rgba(255, 205, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(201, 203, 207, 0.2)'
          ],
          borderColor: [
            'rgb(255, 99, 132)',
            'rgb(255, 159, 64)',
            'rgb(255, 205, 86)',
            'rgb(75, 192, 192)',
            'rgb(54, 162, 235)',
            'rgb(153, 102, 255)',
            'rgb(201, 203, 207)'
          ],        },
      ],
    },
    options: this.chartOptions,
  });

}

createChart2() {
  const labels = this.ListUsersByRegion.map(data => data.key);
  const values = this.ListUsersByRegion.map(data => data.value);
  new Chart("myChart2", {
    type: 'doughnut',
    data: {
         labels: labels,
         datasets: [
         {
             label: "Nombre de user",
             data: values,
         }, 
        ]
    },
});

}
  
  fetchData(): void {
    this.apiService.userPostwithLocation().subscribe(
      data => {
        this.chartData = data;
        this.createChart();
      },
      error => {
        console.error(error);
      }
    );
    this.apiService.getUsersByRegion().subscribe(
      data => {
        this.ListUsersByRegion = data;
        this.createChart2();
      },
      error => {
        console.error(error);
      }
    );
    this.apiServiceUser.getCountUser().subscribe(
      data => {
        this.CountUsers = data;
      },
      error => {
        console.error(error);
      }
    );
    this.apiServicePost.getPostsPending().subscribe(data => {
      this.countPostPending = data.length;
   });
   this.apiServiceRealState.getRealEstatePending().subscribe(data =>{
    this.countPostAnnoncePending = data.length;
 });

  }



}
