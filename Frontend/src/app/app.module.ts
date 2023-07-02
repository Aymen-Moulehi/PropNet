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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import {MapComponent} from './map/map.component';
import { ClaimComponent } from './claim/claim.component';
import { DetailsAnnonceComponent } from './details-annonce/details-annonce.component';

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
    ClaimComponent,
    UpdateAccountComponent,
    ResetpasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
