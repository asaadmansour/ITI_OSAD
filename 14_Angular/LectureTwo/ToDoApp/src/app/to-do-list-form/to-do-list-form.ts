import { Component } from '@angular/core';
import { ToDoInput } from "../to-do-input/to-do-input";
import { ToDoListItems } from "../to-do-list-items/to-do-list-items";

@Component({
  selector: 'app-to-do-list-form',
  imports: [ToDoInput, ToDoListItems],
  templateUrl: './to-do-list-form.html',
  styleUrl: './to-do-list-form.css',
})
export class ToDoListForm {
    todos: string[] = [];
    handleTodoAdded(todoText: string) {
      this.todos.push(todoText);
    }
}
