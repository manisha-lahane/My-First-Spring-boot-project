package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrgnizerRepository;

@Service
public class OrgnizerService {
@Autowired
OrgnizerRepository orgnizerRepository;
	public Organizer addOrganizer(Organizer organizer) {
		
		return orgnizerRepository.save(organizer);
	}
	public List<Organizer> GetAllData(Organizer organizer) {
		
		return orgnizerRepository.findAll();
	}
	 public Optional<Organizer> getOrganizerById(Long id) {
	        return orgnizerRepository.findById(id);
	    }
	public void deleteOrganize(long id) {
		
		orgnizerRepository.deleteById(id);
	}
	public Organizer updateOrganizse(long id, Organizer oldorganizer) {
		Optional<Organizer>oldorganizer1=orgnizerRepository.findById(id);
		if(oldorganizer1.isPresent()) {
			Organizer organizer=oldorganizer1.get();
			organizer.setContactInfo(oldorganizer.getContactInfo());
			organizer.setName(oldorganizer.getName());
			return orgnizerRepository.save(organizer);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
