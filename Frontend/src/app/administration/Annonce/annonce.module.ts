import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AnnonceRoutingModule } from './annonce-routing.module';
import { ListAnnonceComponent } from './list-annonce/list-annonce.component';
import { FilterAnnonceComponent } from './filter-annonce/filter-annonce.component';


@NgModule({
  declarations: [
    ListAnnonceComponent,
    FilterAnnonceComponent,
  ],
  imports: [
    CommonModule,
    AnnonceRoutingModule
  ]
})
export class AnnonceModule { }
