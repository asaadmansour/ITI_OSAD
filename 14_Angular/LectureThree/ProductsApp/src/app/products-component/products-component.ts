import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Productcomponent,Product } from '../product-component/productcomponent';
import productsData from '../../data/products.json'; 
@Component({
  selector: 'app-products-component',
  imports: [CommonModule,Productcomponent],
  templateUrl: './products-component.html',
  styleUrl: './products-component.css',
})
export class ProductsComponent {
  products:Product[] = productsData;
}
