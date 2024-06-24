import { FoodItem } from "../../shared/models/food-item";
import { Restaurant } from "../../shared/models/restaurant";

export interface OrderDTO {

    foodItemsList: FoodItem[];
    userId: number;
    restaurant: Restaurant;
}