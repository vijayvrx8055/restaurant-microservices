import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderRoutingModule } from './order-routing.module';
import { OrderComponent } from './component/order/order.component';
import { ConfirmationModalComponent } from './component/confirmation-modal/confirmation-modal.component';


@NgModule({
  declarations: [
    OrderComponent,
    ConfirmationModalComponent
  ],
  imports: [
    CommonModule,
    OrderRoutingModule
  ]
})
export class OrderModule { }
