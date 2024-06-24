import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { API_URL_ORDER_HOST } from '../../shared/constants/app-constant';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  apiURL = API_URL_ORDER_HOST + '/orders'

  constructor(private http: HttpClient) { }

  saveOrder(data: any): Observable<any> {
    return this.http.post<any>(`${this.apiURL}`, data)
      .pipe(catchError(this.handleError));
  }
  handleError(error: any) {
    console.log('Error in placing Order', error);
    return of(null);
  }

}
