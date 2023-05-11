import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private posturl = "http://localhost:8907/user";
  private geturl = "http://localhost:8907/user";

  constructor(private http : HttpClient) { }

  createUser(user : Object) : Observable<Object>{
    return this.http.post(this.posturl, user);
  }

  getUser(): Observable<any[]>{
    return this.http.get<any[]>(this.geturl);
  }
}
