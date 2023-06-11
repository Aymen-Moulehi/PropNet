import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { AccueilComponent } from './accueil/accueil.component';
import { TempComponent } from './temp/temp.component';
import { ContactComponent } from './contact/contact.component';
import { SingupComponent } from './singup/singup.component';
import { AddAnnonceComponent } from './add-annonce/add-annonce.component';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';
import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';

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
    DetailAnnonceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
