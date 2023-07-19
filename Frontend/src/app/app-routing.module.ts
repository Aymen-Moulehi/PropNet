import {ListAnnoncesComponent} from './list-annonces/list-annonces.component';
import {AddAnnonceComponent} from './add-annonce/add-annonce.component';
import {SingupComponent} from './singup/singup.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';

import {MapComponent} from './map/map.component';

import {NotFoundComponent} from './not-found/not-found.component';
import { ClaimComponent } from './claim/claim.component';
import { DetailsAnnonceComponent } from './details-annonce/details-annonce.component';
import { TestComponentComponent } from './test-component/test-component.component';


const routes: Routes = [
  {path:'', component: AccueilComponent},
  {path:'test', component: TestComponentComponent},
  {path:'claim', component: ClaimComponent},
  {path:'list-annonces', component: ListAnnoncesComponent},
  {path:'admin/annonce/listAnnonces/detail/:id', component: DetailsAnnonceComponent},
  {path:'admin/dashbord/annonce/listAnnonces/detail/:id', component: DetailsAnnonceComponent},


  {path:'singup', component: SingupComponent},
  {path:'Add-Annonce', component: AddAnnonceComponent},

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
