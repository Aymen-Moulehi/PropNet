import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdministrationRoutingModule} from './administration-routing.module';
import {AdministrationComponent} from '../administration/administration.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import { GestionClaimsComponent } from './gestion-claims/gestion-claims.component';
import { UpdateClaimComponent } from './update-claim/update-claim.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AdministrationComponent,
    DashboardComponent,
    GestionClaimsComponent,
    UpdateClaimComponent,
  ],
  imports: [
    CommonModule,
    AdministrationRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AdministrationModule { }
