import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { EventsIntf } from 'src/app/EventsIntf';
import { EventsService } from '../events.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {

  form !: any;
  events !: EventsIntf;

  ngOnInit(): void{
    this.form = new FormGroup({
      eventCategory : new FormControl(),
      eventName : new FormControl(),
      eventDescription : new FormControl(),
      eventDate : new FormControl(),
      eventLocation : new FormControl(),
      eventStatus : new FormControl(),
      eventPrice : new FormControl()
    })
  }

  constructor(private service : EventsService, private router: Router) { }

  addSave(){
    this.service.createEvents(this.events)
    .subscribe(data => console.log(data));
  }

  onSubmit(e : any){
    console.log(e);
    this.events = e;
    this.addSave();
    this.router.navigateByUrl('/admin');
    // window.open("http://localhost:4200/admin", "_self");
  }

}
