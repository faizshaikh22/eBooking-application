import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrdersService } from '../orders.service';
import { AuthService } from 'src/app/auth.service';
import { EventsService } from '../events.service';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {

  userId !: number;
  ordersList !: any[];
  orders: any[] = [];
  eventName!: string;
  eventDate!: Date | null;
  eventDescription!: string;


  displayedColumns: string[] = ['orderId', 'orderStatus', 'orderDate', 'ticketCategory', 'ticketPrice', 'ticketQuantity', 'promoCodeDiscount', 'eventId', 'userId', 'delete'];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ordersService: OrdersService,
    private authService: AuthService,
    private eventsService: EventsService
  ) { }


  ngOnInit() {
    this.route.params.subscribe(params => {
      this.userId = params['userId'];
      this.getOrdersByUserId();
    });
  }


  getOrdersByUserId() {
    this.ordersService.getOrdersByUserId(this.userId).subscribe(
      data => this.ordersList = data
    );
  }
  

  deleteOrder(orderId: number) {
    if (confirm('Are you sure you want to delete this order?')) {
      this.ordersService.deleteOrder(orderId).subscribe(() => {
        this.ordersList = this.ordersList.filter(order => order.orderId !== orderId);
      });
    }
  }

}

