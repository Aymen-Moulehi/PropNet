import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdministrationComponent} from './administration.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import { GestionClaimsComponent } from './gestion-claims/gestion-claims.component';

const routes: Routes = [
  {path:'', component: AdministrationComponent, children:[
      {path:'', component: DashboardComponent},
      {path:'claim', component: GestionClaimsComponent},
      {path:'dashbord', component: DashboardComponent},
      {path:'annonce', loadChildren:()=> import('./Annonce/annonce.module').then(m=>m.AnnonceModule)},
      {path:'forum', loadChildren:()=> import('./forum/forum.module').then(m=>m.ForumModule)},
      {path:'users', loadChildren:()=> import('./user/user.module').then(m=>m.UserModule)},


    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
