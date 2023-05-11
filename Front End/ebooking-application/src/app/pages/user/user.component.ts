import { Component } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  userId: string = '';

  constructor(private authService: AuthService) {
    const userId = this.authService.getUserId();
    if (userId !== null) {
      this.userId = userId;
    }
    else{
      alert('Please login to access Order Details.');
    }
  }  

}
