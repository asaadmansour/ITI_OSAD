import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [NgClass, FormsModule],
  templateUrl: './users.html',
  styleUrl: './users.css',
})
export class Users {
  users = [
    {
      "id": 1,
      "profilePicture": "ahmed.png",
      "username": "ahmed_hassan",
      "email": "ahmed.hassan@gmail.com",
      "phoneNumber": "+20 100 234 5678",
      "birthdate": "1995-03-15",
      "role": "admin"
    },
    {
      "id": 2,
      "profilePicture": "fatima.png",
      "username": "fatima_mohamed",
      "email": "fatima.mohamed@outlook.com",
      "phoneNumber": "+20 111 876 5432",
      "birthdate": "1992-07-22",
      "role": "moderator"
    },
    {
      "id": 3,
      "profilePicture": "mohamed.png",
      "username": "mohamed_ali",
      "email": "m.ali@yahoo.com",
      "phoneNumber": "+20 122 345 6789",
      "birthdate": "1985-11-08",
      "role": "moderator"
    },
    {
      "id": 4,
      "profilePicture": "nour.png",
      "username": "nour_elsayed",
      "email": "nour.elsayed@gmail.com",
      "phoneNumber": "+20 106 987 1234",
      "birthdate": "1998-05-30",
      "role": "user"
    }
  ];
  searchTerm:string = "";
  get filteredUsers() {
    if(!this.searchTerm) {
      return this.users;
    }
    return this.users.filter(user=> user.username.toLowerCase().includes(this.searchTerm.toLocaleLowerCase()));
  }
}
