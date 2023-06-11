import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';
import { ContactComponent } from './contact/contact.component';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';
import { AddAnnonceComponent } from './add-annonce/add-annonce.component';
import { SingupComponent } from './singup/singup.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';

const routes: Routes = [
  {path:'', component: AccueilComponent}, 
  {path:'contact', component: ContactComponent}, 

  {path:'list-annonces', component: ListAnnoncesComponent}, 
  {path:'detail', component: DetailAnnonceComponent}, 


  {path:'singup', component: SingupComponent}, 
  {path:'Add-Annonce', component: AddAnnonceComponent}, 



  
  {path:'admin', loadChildren:()=> import('./administration/administration.module').then(m=>m.AdministrationModule)},
  {path:'forume', loadChildren:()=> import('./forum/forum.module').then(m=>m.ForumModule)},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
