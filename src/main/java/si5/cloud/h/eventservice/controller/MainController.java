package si5.cloud.h.eventservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si5.cloud.h.eventservice.controller.model.Event;
import si5.cloud.h.eventservice.controller.model.dto.EventBookDTO;
import si5.cloud.h.eventservice.service.EventService;

@RestController
@RequestMapping("/events")
public class MainController {
    
    @Autowired
	EventService eventService;
    
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body("Event service is up.");
    }
	
	@GetMapping
	public ResponseEntity<List<Event>> getEvents() {
		return ResponseEntity.ok(eventService.getEvents());
	}
	
	@GetMapping(value = "/db")
	public ResponseEntity<List<Event>> getDBEvents() {
		return ResponseEntity.ok(eventService.getDBEvents());
	}
	
	@PostMapping(value = "/addEvent")
	public ResponseEntity<String> addEvent(@RequestBody Event event) {
		return ResponseEntity.ok(eventService.addEvent(event) ? "Event was successfully added" : "Failed to add event");
	}
	
	@PatchMapping(value = "/updateEvent")
	public ResponseEntity<String> updateEvent(@RequestBody Event event) {
		return ResponseEntity.ok(eventService.updateEvent(event) ? "Event was successfully updated" : "Event was not found and could not be updated");
	}
	
	@PostMapping(value = "/bookTicket")
	public ResponseEntity<String> bookTicket(@RequestBody EventBookDTO eventBook) {
		return ResponseEntity.ok(eventService.bookTicket(eventBook) ? 
				String.format("Ticket was successfully booked for holder %s and event %s", eventBook.getTicketHolder(), eventBook.getEventName()) : 
					String.format("Error booking ticket for holder %s and event %s", eventBook.getTicketHolder(), eventBook.getEventName()));
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
