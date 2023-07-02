import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdministrationRoutingModule} from './administration-routing.module';
import {AdministrationComponent} from '../administration/administration.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import { GestionClaimsComponent } from './gestion-claims/gestion-claims.component';


@NgModule({
  declarations: [
    AdministrationComponent,
    DashboardComponent,
    GestionClaimsComponent,
  ],
  imports: [
    CommonModule,
    AdministrationRoutingModule
  ]
})
export class AdministrationModule { }
