import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of, throwError } from 'rxjs';
import { API_URL_FOOD_CATALOGUE_HOST } from '../../shared/constants/app-constant';

@Injectable({
  providedIn: 'root'
})
export class FoodItemService {

  apiUrl = API_URL_FOOD_CATALOGUE_HOST + '/foodCatalogue/'

  constructor(private http: HttpClient) { }

  fetchRestaurantAndFoodItemById(restaurantId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl + restaurantId}`)
      .pipe(catchError(this.handleError));
  }
  handleError(error: any) {
    console.error('Error while calling food-catalogue service :', error);
    if (error.status === 404) {
      return of({ defaultValue: 'Not Found' });
    } else {
      return throwError(() => new Error('Something bad happened; please try again later.'));
    }
  }
}
