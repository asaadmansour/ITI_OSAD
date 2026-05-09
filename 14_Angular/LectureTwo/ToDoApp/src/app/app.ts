import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ToDoListForm } from './to-do-list-form/to-do-list-form';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,ToDoListForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ToDoApp');
}
