package archicloud.equipeh.eventservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import archicloud.equipeh.eventservice.model.Event;
import archicloud.equipeh.eventservice.service.EventService;

@RestController
@RequestMapping("/events")
public class EventServiceController {
	@Autowired
	EventService eventService;
	
	@GetMapping
	public ResponseEntity<List<Event>> getEvents() {
		return ResponseEntity.ok(eventService.getEvents());
	}
	
	@GetMapping(value = "/addEvent")
	public ResponseEntity<String> addEvent() {
		return ResponseEntity.ok("Add Event - OK");
	}
	
	@GetMapping(value = "/updateEvent")
	public ResponseEntity<String> updateEvent() {
		return ResponseEntity.ok("Update Event - OK");
	}
	
	@GetMapping(value = "/removeTicket")
	public ResponseEntity<String> removeTicket() {
		return ResponseEntity.ok("Remove Ticket - OK");
	}
	
	@GetMapping(value = "/blockTicket")
	public ResponseEntity<String> blockTicket() {
		return ResponseEntity.ok("Block Ticket - OK");
	}
	
	@GetMapping(value = "/unblockTicket")
	public ResponseEntity<String> unblockTicket() {
		return ResponseEntity.ok("Unblock Ticket - OK");
	}
}