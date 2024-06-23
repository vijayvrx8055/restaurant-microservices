import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponent } from './components/restaurant-listing/restaurant-listing.component';
import { RestaurantListingRoutingModule } from './restaurant-listing-routing.module';


@NgModule({
  declarations: [
    RestaurantListingComponent
  ],
  imports: [
    CommonModule,
    RestaurantListingRoutingModule,
    HttpClientModule
  ]
})
export class RestaurantListingModule { }
