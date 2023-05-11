package com.sonata.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Modal.Event;
import com.sonata.Repository.EventRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventRepository repo;
	
	Optional<Event> e;
	
	@GetMapping("")
	public List<Event> getAllEvents(){
		return repo.findAll();
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity getEventById(@PathVariable (value = "eventId") Long eventId) {
		e = repo.findById(eventId);
		return ResponseEntity.ok().body(e);
	}
	
	@GetMapping("/category/{category}")
    public List<Event> getEventsByCategory(@PathVariable (value = "category") String category) {
        return repo.findByEventCategory(category);
    }
	
	@GetMapping("/name/{name}")
	public Long getEventPrice(@PathVariable (value = "name") String name) {
	    List<Event> events = repo.findByEventName(name);
	    if (!events.isEmpty()) {
	        Event event = events.get(0);
	        return event.getEventPrice();
	    }
	    return null; 
	}
	
	@PostMapping("")
	public Event createEvent(@RequestBody Event event) {
		return repo.save(event);
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity updateEvent(@PathVariable (value = "eventId") Long eventId,
			@Validated @RequestBody Event eventDetails) {
		e = repo.findById(eventId);
		Event e2 = e.get();
		
		e2.setEventId(eventId);
//		o2.setOrderDate(java.sql.Date.valueOf("2022-03-23"));
		e2.setEventDate(eventDetails.getEventDate());
		e2.setEventCategory(eventDetails.getEventCategory());
		e2.setEventDescription(eventDetails.getEventDescription());
		e2.setEventLocation(eventDetails.getEventLocation());
		e2.setEventName(eventDetails.getEventName());
		e2.setEventStatus(eventDetails.getEventStatus());
		e2.setEventPrice(eventDetails.getEventPrice());
		
		Event updateE = repo.save(e2);
		return ResponseEntity.ok(updateE);
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity deleteEvent(@PathVariable (value = "eventId") Long eventId) {
		repo.deleteById(eventId);
		return ResponseEntity.noContent().build();
	}

}
