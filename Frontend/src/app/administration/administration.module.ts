import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';
import { AdministrationComponent } from '../administration/administration.component';


@NgModule({
  declarations: [
    AdministrationComponent,
  ],
  imports: [
    CommonModule,

    AdministrationRoutingModule
  ]
})
export class AdministrationModule { }
