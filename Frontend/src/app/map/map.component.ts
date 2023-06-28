import {AfterViewInit, Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit {
  private map:any;
  private lat!:number;
  private lon!:number;
  private markerItem:any;

  private initMap(): void {
    this.lat = this.route.snapshot.params['latitude'];
    this.lon = this.route.snapshot.params['longitude'];

    this.map = L.map('map', {
      center: [ this.lon, this.lat],
      zoom: 20
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    this.markerItem= L.marker([this.lon, this.lat]).addTo(this.map).bindPopup("Your place is here!");
    this.map.fitBounds([
      this.markerItem.getLatLng().lat,this.markerItem.getLatLng().lng
    ])
    console.log(this.lat, this.lon);
  }

  constructor(private route:ActivatedRoute) { }

  ngAfterViewInit(): void {
    this.initMap();
  }
}

