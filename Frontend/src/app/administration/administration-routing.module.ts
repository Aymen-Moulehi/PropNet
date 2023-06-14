import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationComponent } from './administration.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClaimComponent } from './claim/claim.component';

const routes: Routes = [
    {path:'', component: AdministrationComponent, children:[
    {path:'', component: DashboardComponent}, 
    {path:'claim', component: ClaimComponent}, 
    {path:'dashbord', component: DashboardComponent}, 
    {path:'forum', loadChildren:()=> import('./forum/forum.module').then(m=>m.ForumModule)},
    {path:'annonce', loadChildren:()=> import('./Annonce/annonce.module').then(m=>m.AnnonceModule)},
    
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
