import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { EventsIntf } from 'src/app/EventsIntf';
import { OrdersIntf } from 'src/app/OrdersIntf';
import { EventsService } from '../events.service';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  form!: FormGroup;
  order!: OrdersIntf;
  o1!: any[];
  e1!: any[];
  name !: any[];
  date!: Date;
  eventId !: number;
  selectedEvent !: EventsIntf;


  constructor(
    private service: OrdersService, 
    private eventService: EventsService, 
    private authService : AuthService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      orderStatus: new FormControl('active'),
      orderDate: new FormControl(new Date()),
      eventCategory: new FormControl(),
      eventName: new FormControl(),
      ticketCategory: new FormControl(),
      ticketPrice: new FormControl(),
      ticketQuantity: new FormControl(),
      promoCodeDiscount: new FormControl(),
      eventId: new FormControl()
    });
    this.getEvents();

    this.form.valueChanges.subscribe(() => {
      this.calculateTotalPrice();
    });

    this.form.controls['eventCategory'].valueChanges.subscribe((value) => {
      this.getEventsByCategory(value);
    });

  }

  addSave() {
    this.service.createOrder(this.order).subscribe((data) => console.log(data));
  }

  getOrders() {
    this.service.getOrders().subscribe((data) => (this.o1 = data));
  }

  getEvents() {
    this.eventService.getEvents().subscribe((data) => {
      this.e1 = data;
    });
  }

  getEventsByCategory(category: string) {
    this.eventService.getEventsByCategory(category).subscribe((data) => {
      this.e1 = data;
      this.form.controls['eventName'].setValue(null);
    });
  }

  onEventNameSelected(event: any) {
    const selectedEvent = this.e1.find((e: any) => e.eventName === event.value);
    if (selectedEvent) {
      this.form.patchValue({
        eventId: selectedEvent.id
      });
      this.calculateTotalPrice();
      this.selectedEvent = selectedEvent;
    }
  }
  
  onSubmit(o: any) {
    console.log(o);
    this.calculateTotalPrice();
    this.order = {
      ...o,
      userId: parseInt(this.authService.getUserId()!),
      eventId: this.selectedEvent.eventId
    };
    this.addSave();
    this.router.navigateByUrl('/user');
    // window.open("http://localhost:4200/user", "_self");
  }
  

  calculateTotalPrice() {
    const event = this.e1.find((e: any) => e.eventName === this.form.controls['eventName'].value);
    const ticketCategory = this.form.controls['ticketCategory'].value;
    const ticketQuantity = this.form.controls['ticketQuantity'].value;
    const promoCodeDiscount = this.form.controls['promoCodeDiscount'].value;
    
    let ticketPrice = event.eventPrice;
    this.eventId = event.id;

    if (ticketCategory === 'second') {
      ticketPrice *= 1.2;
    } else if (ticketCategory === 'third') {
      ticketPrice *= 1;
    } else {
      ticketPrice *= 1.5;
    }
  
    if (promoCodeDiscount == 10) {
      ticketPrice *= 0.9;
    } else if (promoCodeDiscount == 30) {
      ticketPrice *= 0.7;
    } else if (promoCodeDiscount == 50) {
      ticketPrice *= 0.5;
    }
  
    const totalPrice = ticketPrice * ticketQuantity;
    if (this.form.controls['ticketPrice'].value !== totalPrice) {
      this.form.controls['ticketPrice'].setValue(totalPrice);
    }
  }

}
