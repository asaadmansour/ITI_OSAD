import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './header/header';
import { Hero } from './hero/hero';
import { Projects } from './projects/projects';
import { Education } from './education/education';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header,Hero,Projects,Education],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('myFirstApp');
}
