import { Component, OnInit, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product} from '../iproduct'
import { ProductService } from '../productService';
import { Productcomponent } from '../product-component/productcomponent';
import { CartService } from '../cart-service';
@Component({
  selector: 'app-product-details',
  imports: [CommonModule,Productcomponent],
  templateUrl: './product-details.html',
  styleUrl: './product-details.css',
})
export class ProductDetails implements OnInit { 
  product = signal<Product | undefined>(undefined);
  isLoading = signal<boolean>(true);
  
  constructor(private route: ActivatedRoute,private productService:ProductService,private cartService:CartService) {}
  
  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
        this.isLoading.set(true);
        this.productService.getProductById(id).subscribe({
          next: (data) => {
            this.product.set(data);
            this.isLoading.set(false);
          },
          error: (err) => {
            console.error(err);
            this.isLoading.set(false);
          }
      });
    } else {
      this.isLoading.set(false);
    }
  }
  addToCart() {
    const product = this.product();
    if (product) {
      this.cartService.addToCart(product);
    }
  }
}
