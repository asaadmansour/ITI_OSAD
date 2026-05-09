import { Component, computed } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartService } from '../cart-service';

@Component({
  selector: 'app-cart-component',
  imports: [CommonModule],
  templateUrl: './cart-component.html',
  styleUrl: './cart-component.css',
})
export class CartComponent {
  cartItems;
  totalPrice = computed(() => {
     return this.cartItems().reduce((sum, item) => sum + (item.price * item.quantity), 0);
  });
  totalItems = computed(() => {
     return this.cartItems().reduce((sum, item) => sum + item.quantity, 0);
  });
  constructor(private cartService: CartService) {
    this.cartItems = this.cartService.cartItems;
  }
}
