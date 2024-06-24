import { FoodItem } from "./food-item";
import { Restaurant } from "./restaurant";

export interface FoodCataloguePage {
    foodItemsList: FoodItem[];
    restaurant: Restaurant;
}