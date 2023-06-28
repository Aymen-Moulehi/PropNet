import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListAnnonceComponent} from 'src/app/administration/Annonce/list-annonce/list-annonce.component';

const routes: Routes = [

  {path:'listAnnonces', component: ListAnnonceComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AnnonceRoutingModule { }
