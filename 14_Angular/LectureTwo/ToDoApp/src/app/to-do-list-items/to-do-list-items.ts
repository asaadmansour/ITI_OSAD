import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-to-do-list-items',
  imports: [],
  templateUrl: './to-do-list-items.html',
  styleUrl: './to-do-list-items.css',
})
export class ToDoListItems {
  @Input() todos:string[] = [];
}
