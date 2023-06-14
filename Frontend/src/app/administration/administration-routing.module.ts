import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationComponent } from './administration.component';

const routes: Routes = [
  {path:'', component: AdministrationComponent, children:[

    {path:'forum', loadChildren:()=> import('./forum/forum.module').then(m=>m.ForumModule)},
    {path:'claim', loadChildren:()=> import('./claim/claim.module').then(m=>m.ClaimModule)},

    {path:'annonce', loadChildren:()=> import('./Annonce/annonce.module').then(m=>m.AnnonceModule)},




  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
