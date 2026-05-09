import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from "@angular/router";
import { Auth } from '../auth';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  constructor(public authService:Auth,private router:Router) {}
  logout() {
    this.authService.logout();
    this.router.navigate(["/login"]);
  }
}
