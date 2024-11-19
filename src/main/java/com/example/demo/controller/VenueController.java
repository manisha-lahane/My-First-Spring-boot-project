package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Venue;
import com.example.demo.service.VenueService;

@RestController
@RequestMapping("/api")
public class VenueController {
	@Autowired
	VenueService venueService;

	@PostMapping("/createVenue")
	public Venue createVenue(@RequestBody Venue venue) {
		return venueService.createVenue(venue);
	}
	@GetMapping("/allData")
	public List<Venue> allData(@RequestBody Venue venue) {
		return venueService.allData(venue);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
		Optional<Venue> venue = venueService.getVenueById(id);
		return venue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/deleteVenue")
	public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
		venueService.deleteVenue(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updateVenue/{id}")
	public ResponseEntity<Venue>updateVenue(@PathVariable long id,@RequestBody Venue venueDetails){
		Venue updateVenue=venueService.updateVenue(id,venueDetails);
				
			if(updateVenue!=null) {
				return ResponseEntity.ok(updateVenue);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		
	}


