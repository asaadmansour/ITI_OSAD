import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Output, EventEmitter } from '@angular/core';
@Component({
  selector: 'app-to-do-input',
  imports: [FormsModule],
  templateUrl: './to-do-input.html',
  styleUrl: './to-do-input.css',
})
export class ToDoInput {
  todoText:string = "";
  @Output() todoAdded = new EventEmitter<string>();
onAddTodo() {
  if (this.todoText.trim()) { 
    this.todoAdded.emit(this.todoText);
    this.todoText = "";
  }
}
}
