import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  image: string;
  rating: number;
  quantity: number;
}
@Component({
  selector: 'app-productcomponent',
  imports: [CommonModule, RouterLink],
  templateUrl: './productcomponent.html',
  styleUrl: './productcomponent.css',
})
export class Productcomponent {
  @Input() product!: Product;
  
  get isInStock(): boolean {
    return this.product.quantity > 0;
  }
  
  get stockBadge(): string {
    return this.product.quantity > 0 ? 'In Stock' : 'Out of Stock';
  }
  
  get stars(): string {
    const filled = '★'.repeat(this.product.rating);
    const empty = '☆'.repeat(5 - this.product.rating);
    return filled + empty;
  }
}
