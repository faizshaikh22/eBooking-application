import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EventsService {
  private geturl = "http://localhost:8908/event";
  private posturl = "http://localhost:8908/event"

  constructor(private http : HttpClient) { }

  createEvents(events : Object) : Observable<Object>{
    return this.http.post(this.posturl, events);
  }

  getEvents() : Observable<any[]>{
    return this.http.get<any[]>(this.geturl);
  }

  getEventsByCategory(category: string): Observable<any[]> {
    const url = `${this.geturl}/category/${category}`;
    return this.http.get<Event[]>(url);
  }

  getEventPriceByEventName(name : string): Observable<any[]>{
    const url = `${this.geturl}/name/${name}`;
    return this.http.get<any[]>(url);
  }

  getEventsById(eventId :number) : Observable<any>{
    return this.http.get<any>(`http://localhost:8908/event/${eventId}`);
  }
}
