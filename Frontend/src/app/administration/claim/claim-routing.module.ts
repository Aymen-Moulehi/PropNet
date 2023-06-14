import { DetaileClaimComponent } from './detaile-claim/detaile-claim.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListClaimComponent } from './list-claim/list-claim.component';

const routes: Routes = [
  {path:'listclaim', component: ListClaimComponent}, 
  {path:'detailclaim', component: DetaileClaimComponent}, 



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClaimRoutingModule { }
