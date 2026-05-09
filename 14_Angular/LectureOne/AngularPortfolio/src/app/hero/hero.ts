import { Component } from '@angular/core';

@Component({
  selector: 'app-hero',
  imports: [],
  templateUrl: './hero.html',
  styleUrl: './hero.css',
})
export class Hero {
  name: string = "Asaad";
  title: string = "Software Engineer";
  forkifyUrl: string = "/forkify.png";           
  basketUrl: string = "/basket.png";             
  chickenUrl: string = "/chickenInvaders.png";   
  connviaUrl: string = "/connvia.jpeg";      
  javaUrl:string = "/java.webp"  
  reactUrl:string = "/React.webp"
  angularUrl:string = "/angular.webp"
  mongoUrl:string = "/mongo.webp"
  sqlUrl:string = "/sql.webp"
  laravelUrl:string = "/laravel.webp"
  viewCV() {
    window.open('/asaadCv.pdf', '_blank');
  }
}