package si5.cloud.h.eventservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si5.cloud.h.eventservice.controller.model.Event;
import si5.cloud.h.eventservice.controller.model.Ticket;
import si5.cloud.h.eventservice.controller.model.dto.EventBookDTO;

@Service
public class EventService {
	@Autowired
	private EventPersistenceService eventPersistenceService;
	
	private List<Event> events = 
			Arrays.asList(new Event[] {
			new Event("Nuit de l'Info", "C'est la nuit de l'Info", "Sophia - Lucioles", "15/12/22 18:00-00:00", 100),
			new Event("Hackathon", "C'est le Hakcathon", "Sophia - Templiers", "10/11/22 16:00-20:00", 100)});
	
	public List<Event> getEvents() {
		return events;
	}
	
	public List<Event> getDBEvents() {
		return eventPersistenceService.getEventsInDb();
	}
	
	public Boolean addEvent(Event event) {
		return Boolean.valueOf(events.add(event));
	}
	
	public Boolean updateEvent(Event event) {
		Optional<Event> optEvent = events.stream().filter(e -> e.getName().equals(event.getName())).findFirst();
		
		if (optEvent.isPresent()) {
			// remove previous event obj
			events.remove(optEvent.get());
			return Boolean.valueOf(events.add(event));
		} else {
			return false;
		}
	}
	
	public Boolean bookTicket(EventBookDTO eventBook) {
		Optional<Event> optEvent = events.stream().filter(e -> e.getName().equals(eventBook.getEventName())).findFirst();
		
		if (optEvent.isPresent()) {
			// remove previous event obj
			try {
				optEvent.get().bookTicket(new Ticket(eventBook.getTicketHolder()));
			} catch (IllegalArgumentException iae) {
				// no more tickets
			}
			
			return true;
		} else {
			return false;
		}
	}
}
