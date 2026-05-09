import { Component } from '@angular/core';

@Component({
  selector: 'app-projects',
  imports: [],
  templateUrl: './projects.html',
  styleUrl: './projects.css',
})
export class Projects {
  forkifyUrl:string = "/forkify.png";
  connviaUrl:string = "/connvia.jpeg";
  basketUrl:string = "/basket.png";
  chickenInvadersUrl:string = "/chickenInvaders.png";
}
