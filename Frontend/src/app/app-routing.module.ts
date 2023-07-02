import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';
import { ContactComponent } from './contact/contact.component';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';
import { AddAnnonceComponent } from './add-annonce/add-annonce.component';
import { SingupComponent } from './singup/singup.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { ListUserComponent } from './administration/user/list-user/list-user.component';
import { ClaimComponent } from './claim/claim.component';
import {MapComponent} from './map/map.component';

const routes: Routes = [
  {path:'', component: AccueilComponent},
  {path:'contact', component: ContactComponent},
  {path:'claim', component: ClaimComponent},
  {path:'list-annonces', component: ListAnnoncesComponent},
  {path:'admin/annonce/listAnnonces/detail/:id', component: DetailAnnonceComponent},
  {path:'resetpassword', component: ResetpasswordComponent},
  {path:'singup', component: SingupComponent},
  {path:'Add-Annonce', component: AddAnnonceComponent},
  {path:'update', component: UpdateAccountComponent},
  {path:'map/:latitude/:longitude', component: MapComponent},








  {path:'admin', loadChildren:()=> import('./administration/administration.module').then(m=>m.AdministrationModule)},
  {path:'forume', loadChildren:()=> import('./forum/forum.module').then(m=>m.ForumModule)},
  {path:'**', component: NotFoundComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
