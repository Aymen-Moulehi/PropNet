import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {FooterComponent} from './footer/footer.component';
import {AccueilComponent} from './accueil/accueil.component';
import {TempComponent} from './temp/temp.component';
import {ContactComponent} from './contact/contact.component';
import {SingupComponent} from './singup/singup.component';
import {AddAnnonceComponent} from './add-annonce/add-annonce.component';
import {ListAnnoncesComponent} from './list-annonces/list-annonces.component';
import {DetailAnnonceComponent} from './detail-annonce/detail-annonce.component';
import {HttpClientModule} from '@angular/common/http';

import {MapComponent} from './map/map.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { SuccessPostComponent } from './success-post/success-post.component';
import { SimulateurCreditComponent } from './simulateur-credit/simulateur-credit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    AccueilComponent,
    TempComponent,
    ContactComponent,
    SingupComponent,
    AddAnnonceComponent,
    ListAnnoncesComponent,
    DetailAnnonceComponent,
    MapComponent,
    SuccessPostComponent,
    SimulateurCreditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    NoopAnimationsModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
