package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
@Service
public class EventService {
@Autowired
EventRepository eventRepository;
	public Event saveEvent(Event event) {
		
		return eventRepository.save(event);
	}
	public List<Event> getEvent(Event event) {
		
		return eventRepository.findAll();
	}
	public Optional<Event> getEventById(Long id) {
		
		return eventRepository.findById(id);
	}
	public Event updateEvent(Long id, Event updatedEvent) {
		if(eventRepository.existsById(id)) {
			updatedEvent.setId(id);
			return eventRepository.save(updatedEvent);
		}
		return null;
	}
	public String deleteEvent(Long id) {
		eventRepository.deleteById(id);
		return "data delete successfully..";
		
	}
	public List<Event> getEventsByOrganizer(Long organizerId) {
		
		return eventRepository.findByOrganizerId(organizerId);
	}
	public List<Event> getEventsByVenue(Long venueId) {
		// TODO Auto-generated method stub
		return eventRepository.findByVenueId(venueId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
