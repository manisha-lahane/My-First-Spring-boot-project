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

import com.example.demo.entity.Organizer;
import com.example.demo.service.OrgnizerService;

@RestController
@RequestMapping("/Or")
public class OrgnizerController {
	@Autowired
	OrgnizerService Orgnizerservice;
	@PostMapping("/addOrganizer")
	public Organizer addOrganizer(@RequestBody Organizer organizer) {
		return Orgnizerservice.addOrganizer(organizer);
	}
	
	@GetMapping("GetAllData")
	public List<Organizer>GetAllData(@RequestBody Organizer organizer ){
		return Orgnizerservice.GetAllData(organizer);
	}
	@GetMapping("{id}")
	public ResponseEntity<Organizer>getOrganizerById(@PathVariable long id){
		Optional<Organizer>organizer= Orgnizerservice.getOrganizerById(id);
		return organizer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void>deleteOrganize(@PathVariable long id){
		Orgnizerservice.deleteOrganize(id);
		return ResponseEntity.noContent().build();
				
	}
	@PutMapping("{id}")
	public ResponseEntity<Organizer>updateOrganizse(@PathVariable long id,@RequestBody Organizer oldorganizer ){
		Organizer updateOrganizse=Orgnizerservice.updateOrganizse(id,oldorganizer);
		if(updateOrganizse!=null) {
			return ResponseEntity.ok(updateOrganizse);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
