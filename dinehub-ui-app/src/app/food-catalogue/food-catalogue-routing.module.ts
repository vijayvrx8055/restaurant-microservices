import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FoodCatalogueComponent } from './component/food-catalogue/food-catalogue.component';

const routes: Routes = [
  { path: 'food-catalogue/:restaurantId', component: FoodCatalogueComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FoodCatalogueRoutingModule { }
