import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HeaderComponent } from './components/header.component';
import { HeaderRoutingModule } from './header-routing.module';



@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    HeaderRoutingModule
  ],
  exports: [HeaderComponent]
})
export class HeaderModule { }
