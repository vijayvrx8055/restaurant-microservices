import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from '../../../shared/models/restaurant';
import { RestaurantService } from '../../services/restaurant.service';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.css'
})
export class RestaurantListingComponent {

  public restaurantList: Restaurant[];

  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantService: RestaurantService) { }

  getAllRestaurants() {
    this.restaurantService.getAllRestaurantDetails().subscribe(
      data => {
        this.restaurantList = data;
      }
    )
  }

  onButtonClick(restaurantId: string) {
    this.router.navigate(['/food-catalogue', restaurantId])
  }

}
