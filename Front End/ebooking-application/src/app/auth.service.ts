import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userId: string = '';

  constructor() { }

  getUserId(): string | null {
    return localStorage.getItem('userId');
  }
  
}
