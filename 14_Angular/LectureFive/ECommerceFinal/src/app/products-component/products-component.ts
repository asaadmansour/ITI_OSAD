import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Productcomponent } from '../product-component/productcomponent';
import { ProductService } from '../productService';
import { Product } from '../iproduct';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-products-component',
  imports: [CommonModule,Productcomponent],
  templateUrl: './products-component.html',
  styleUrl: './products-component.css',
})
export class ProductsComponent {
  isLoading = signal<boolean>(true);
  products = signal<Product[]>([]);
  constructor(private productService: ProductService) {}

  getData() {
    this.isLoading.set(true);
    this.productService.getData().subscribe({
      next: (data) => {
        console.log(data);
        this.products.set(data.products);
        this.isLoading.set(false);
      },
      error: (err) => {
        console.error(err);
        this.isLoading.set(false);
      }
    });
  }

  ngOnInit() {
    this.getData();
  }
}
