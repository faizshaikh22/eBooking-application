import { Component } from '@angular/core';
import { UsersService } from '../users.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email !: string;
  password !: string;
  public users !: any[];

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });
  

  constructor(
    private service : UsersService,
    private router: Router,
    private authService: AuthService
  ) {}

  getUsers(){
    this.service.getUser()
    .subscribe(data => this.users = data);
  }

  ngOnInit(){
    this.getUsers();
  }

  isValid(){
    return this.email && this.email.includes('@' && '.com') && this.password;
    // && this.password.length >= 6;
  }

  login() {
    const user = this.users.find(u => u.userEmail === this.email && u.userPassword === this.password);
    const admin = this.users.find(u => this.email === 'admin@contoso.com' && this.password === 'admin@123');

    if(admin){
      localStorage.setItem('userId', user.userId);
      this.router.navigateByUrl('/admin');
      // window.open("http://localhost:4200/admin", "_self");
    }
    else if (user) {
      localStorage.setItem('userId', user.userId);
      this.router.navigateByUrl('/user');
      // window.open("http://localhost:4200/user", "_self");
    } 
    else {
      window.alert('Invalid credentials');
    }
  }
  
}
