import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private geturl = "http://localhost:8909/orders";
  private posturl = "http://localhost:8909/orders";

  constructor(private http : HttpClient) { }

  getOrders() : Observable<any[]>{
    return this.http.get<any[]>(this.geturl);
  }

  createOrder(orders : Object) : Observable<Object>{
    return this.http.post(this.posturl, orders);
  }

  getOrdersByUserId(userId: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8909/orders/user/${userId}`);
  }

  deleteOrder(orderId : number): Observable<any>{
    return this.http.delete<any>(`http://localhost:8909/orders/${orderId}`);
  }

  getEventsById(eventId :number) : Observable<any>{
    return this.http.get<any>(`http://localhost:8908/event/${eventId}`);
  }
  
}
