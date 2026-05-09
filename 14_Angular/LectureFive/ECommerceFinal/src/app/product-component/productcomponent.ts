import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Product } from '../iproduct';
import { CartService } from '../cart-service';

@Component({
  selector: 'app-productcomponent',
  imports: [CommonModule, RouterLink],
  templateUrl: './productcomponent.html',
  styleUrl: './productcomponent.css',
})
export class Productcomponent {
  @Input() product!: Product;
  
  constructor(private cartService: CartService) {}

  addToCart(event: Event) {
    // You wanted to test WITHOUT stopPropagation first?
    // Remove the comment below to re-enable it later
    event.stopPropagation();
    
    this.cartService.addToCart(this.product);
    console.log('Added to cart:', this.product.title);
  }
  
  get isInStock(): boolean {
    return this.product.stock > 0;
  }
  
  get stockBadge(): string {
    return this.product.stock > 0 ? 'In Stock' : 'Out of Stock';
  }
  
  get stars(): string {
    const filled = '★'.repeat(Math.round(this.product.rating));
    const empty = '☆'.repeat(5 - Math.round(this.product.rating));
    return filled + empty;
  }
}
