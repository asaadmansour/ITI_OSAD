import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './iproduct';
import { catchError, Observable, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private readonly api = "https://dummyjson.com/products";
  // https://dummyjson.com/products/{id}
  constructor(private http:HttpClient){};
  getData(): Observable<any> {
    return this.http.get<any>(this.api).pipe(
      catchError(error => {
        console.error('Service error:', error);
        return throwError(() => error);
      })
    );
  }
  getProductById(id: number): Observable<Product> {
  return this.http.get<Product>(`${this.api}/${id}`);
  }
}