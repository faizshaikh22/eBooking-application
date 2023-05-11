import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserIntf } from 'src/app/UserIntf';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  form !: any;
  user !: UserIntf;

  constructor(private service : UsersService, private router : Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      userId : new FormControl(),
      userName : new FormControl(),
      userEmail : new FormControl(),
      contactNumber : new FormControl(),
      userPassword : new FormControl()
    })
  }

  addSave(){
    this.service.createUser(this.user)
    .subscribe(data => console.log(data));
  }

  onSubmit(u : any){
    console.log(u);
    this.user = u;
    this.addSave();
    this.router.navigateByUrl('/login');
    //window.open("http://localhost:4200/login", "_self");
  }

}

