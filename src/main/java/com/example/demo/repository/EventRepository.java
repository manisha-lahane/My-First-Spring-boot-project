package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	List<Event> findByOrganizerId(Long organizerId);

	List<Event> findByVenueId(Long venueId);
	
	

}
