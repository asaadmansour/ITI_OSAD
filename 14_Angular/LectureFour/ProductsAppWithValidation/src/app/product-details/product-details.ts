import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import productsData from '../../data/products.json';
import { Product, Productcomponent } from '../product-component/productcomponent';

@Component({
  selector: 'app-product-details',
  imports: [CommonModule,Productcomponent],
  templateUrl: './product-details.html',
  styleUrl: './product-details.css',
})
export class ProductDetails implements OnInit { 
  product?: Product;
  
  constructor(private route: ActivatedRoute) {}
  
  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.product = productsData.find(product => product.id === id);
  }
}
