import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {FooterComponent} from './footer/footer.component';
import {AccueilComponent} from './accueil/accueil.component';
import {TempComponent} from './temp/temp.component';
import {SingupComponent} from './singup/singup.component';
import {AddAnnonceComponent} from './add-annonce/add-annonce.component';
import {ListAnnoncesComponent} from './list-annonces/list-annonces.component';
import {HttpClientModule} from '@angular/common/http';
import {MapComponent} from './map/map.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ClaimComponent } from './claim/claim.component';
import { DetailsAnnonceComponent } from './details-annonce/details-annonce.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    AccueilComponent,
    TempComponent,
    SingupComponent,
    AddAnnonceComponent,
    ListAnnoncesComponent,
    MapComponent,
    ClaimComponent,
    DetailsAnnonceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
