import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private isLoggedIn = false;
  login(email:string,password:string):boolean {
    if(email && password) {
      this.isLoggedIn = true;
      localStorage.setItem('isLoggedIn','true');
      localStorage.setItem('token','asa12as');
      return true;
    }
    return false;
  }
  logout():boolean {
    this.isLoggedIn = false;
    localStorage.removeItem("isLoggedIn");
    localStorage.removeItem("token");
    return this.isLoggedIn == false;
  }
  isAuthenticated(): boolean {
    return !!localStorage.getItem('token'); 
  }
}
