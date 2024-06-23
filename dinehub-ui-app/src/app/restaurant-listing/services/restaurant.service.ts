import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of, throwError } from 'rxjs';
import { API_URL_RESTAURANT_LISTING_HOST } from '../../shared/constants/app-constant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private apiUrl = API_URL_RESTAURANT_LISTING_HOST + '/restaurants'

  constructor(private http: HttpClient) { }

  getAllRestaurantDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    console.error('An error occured:', error);
    // Customize this part to return a default value or rethrow the error
    if (error.status === 404) {
      // Return an observable with a default value for 404 errors
      return of({ defaultValue: 'Not Found' });
    } else {
      // For other errors, rethrow the error
      return throwError(() => new Error('Something bad happened; please try again later.'));
    }
  }
}
