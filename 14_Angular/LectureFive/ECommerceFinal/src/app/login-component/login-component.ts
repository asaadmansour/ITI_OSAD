import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Auth } from '../auth';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login-component',
  imports: [FormsModule, CommonModule],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css',
})
export class LoginComponent {
  email:string = '';
  password:string = '';
  constructor(private authService:Auth,private router:Router){}
  onSubmit() {
    if(!this.email || !this.password) return;
    if(this.authService.login(this.email,this.password)) {
      this.router.navigate(["/products"]);
    } 
  }
}
