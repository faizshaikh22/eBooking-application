import { Component } from '@angular/core';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-allorders',
  templateUrl: './allorders.component.html',
  styleUrls: ['./allorders.component.css']
})
export class AllordersComponent {

  public o1 !: any[];
  displayedColumns: string[] = ['orderId', 'orderStatus', 'orderDate', 'ticketCategory', 'ticketPrice', 'ticketQuantity', 'promoCodeDiscount', 'eventId', 'userId'];

  constructor(private service : OrdersService) {}

  ngOnInit(){
    this.getOrders();
  }

  getOrders(){
    this.service.getOrders()
    .subscribe(data => this.o1 = data);
  }

}
