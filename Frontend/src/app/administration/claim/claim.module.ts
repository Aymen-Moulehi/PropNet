import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClaimRoutingModule } from './claim-routing.module';
import { ListClaimComponent } from './list-claim/list-claim.component';
import { DetaileClaimComponent } from './detaile-claim/detaile-claim.component';


@NgModule({
  declarations: [
    ListClaimComponent,
    DetaileClaimComponent
  ],
  imports: [
    CommonModule,
    ClaimRoutingModule
  ]
})
export class ClaimModule { }
