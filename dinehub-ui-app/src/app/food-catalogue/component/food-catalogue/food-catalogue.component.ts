import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodCataloguePage } from '../../../shared/models/food-catalogue-page';
import { FoodItem } from '../../../shared/models/food-item';
import { Restaurant } from '../../../shared/models/restaurant';
import { FoodItemService } from '../../service/food-item.service';

@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrl: './food-catalogue.component.css'
})
export class FoodCatalogueComponent {



  foodItemResponse: FoodCataloguePage;
  restaurantId: string;
  //cart
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;
  restaurant: Restaurant;

  constructor(private route: ActivatedRoute,
    private foodItemService: FoodItemService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.restaurantId = params.get('restaurantId') || 'defaultRestaurantId';
      }
    )
    this.getFoodItemsByRestaurant(this.restaurantId);
  }

  getFoodItemsByRestaurant(restaurantId: string) {
    this.foodItemService.fetchRestaurantAndFoodItemById(restaurantId).subscribe(
      data => {
        this.foodItemResponse = data;
      }
    )
  }

  onCheckout() {
    this.foodItemCart;
    this.orderSummary = {
      foodItemsList: [],
      restaurant: this.restaurant
    }
    this.orderSummary.foodItemsList = this.foodItemCart;
    this.orderSummary.restaurant = this.foodItemResponse.restaurant;
    this.router.navigate(['/order-summary'],
      { queryParams: { data: JSON.stringify(this.orderSummary) } })
  }

  increment(food: FoodItem) {
    //updating quantity
    food.quantity++;
    //finding if same food is already present
    const index = this.foodItemCart.findIndex(item => {
      item.itemId === food.itemId
    });

    if (index === -1) {
      this.foodItemCart.push(food);//push if food not present
    } else {
      this.foodItemCart[index] = food;// update the food if present
    }
  }
  decrement(food: FoodItem) {
    if (food.quantity > 0) {
      food.quantity--;
    }
    const index = this.foodItemCart.findIndex(item => {
      item.itemId === food.itemId
    });

    if (this.foodItemCart[index].quantity == 0) {
      this.foodItemCart.splice(index, 1);
    } else {
      this.foodItemCart[index] = food;// update the food if present
    }
  }
}
