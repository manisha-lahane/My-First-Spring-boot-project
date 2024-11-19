package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	 EventService eventService;
	@Autowired
	EventRepository eventRepository;
		
		@PostMapping("saveEvent")
		public Event saveEvent(@RequestBody Event event) {
			return eventService.saveEvent(event);
		}
		@GetMapping("/getEvent")
		public List<Event>getEvent(@RequestBody Event event){
			return eventService.getEvent(event);
		}
		@GetMapping("getEventById")
		public Optional<Event> getEventById(@PathVariable Long id){
			return eventService.getEventById(id);}
		
  @PutMapping("{id}")
  public Event updateEvent(@PathVariable Long id,@RequestBody Event event ) {
	  
	return eventService.updateEvent(id,event);
	  
  }
  @DeleteMapping("deleteEvent")
  public String deleteEvent(@PathVariable Long id) {
	  return eventService.deleteEvent(id);
  }
  @GetMapping("/organizer/{organizerId}")
	public List<Event>getEventsByOrganizer(@PathVariable Long organizerId){
		return eventService.getEventsByOrganizer(organizerId);
	}
@GetMapping("/venue/{venueId}")
public List<Event>getEventsByVenue(@PathVariable Long venueId ){
	return eventService.getEventsByVenue(venueId);
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
