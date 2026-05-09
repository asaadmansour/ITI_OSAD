import { Injectable, signal } from '@angular/core';
import { Product } from './iproduct';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  cartItems = signal<any[]>([]);
addToCart(newItem: Product) {
  this.cartItems.update(items => {
    const existing = items.find(i => i.id === newItem.id);
    if (existing) {
      existing.quantity++; 
      return [...items];
    } else {
      return [...items, { ...newItem, quantity: 1 }]; 
    }
  });
}
}
