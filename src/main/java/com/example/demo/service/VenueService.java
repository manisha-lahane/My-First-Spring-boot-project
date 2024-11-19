package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Venue;
import com.example.demo.repository.VenueRepository;
@Service
public class VenueService {
@Autowired
VenueRepository venueRepository;
	public Venue createVenue(Venue venue) {
		
		return venueRepository.save(venue);
	}
	public Optional<Venue> getVenueById(Long id) {
		
		return venueRepository.findById(id);
	}
	public void deleteVenue(Long id) {
		
	    venueRepository.deleteById(id);
	}
	public Venue updateVenue(long id, Venue venueDetails) {
		 Optional<Venue> venueOptional = venueRepository.findById(id);
	        if (venueOptional.isPresent()) {
	            Venue venue = venueOptional.get();
	            venue.setName(venueDetails.getName());
	            venue.setLocation(venueDetails.getLocation());
	            venue.setCapacity(venueDetails.getCapacity());
	            return venueRepository.save(venue);
	        }
	        return null;

	
	
	
	
	}
	public List<Venue> allData(Venue venue) {
		
		return venueRepository.findAll();
	}
	
	
	
	
	
	
	
}
