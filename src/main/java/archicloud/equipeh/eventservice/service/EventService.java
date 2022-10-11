package archicloud.equipeh.eventservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import archicloud.equipeh.eventservice.model.Event;

@Service
public class EventService {
	
	public List<Event> getEvents() {
		return Arrays.asList(new Event[] {
				new Event("Nuit de l'Info", "C'est la nuit de l'Info", "Sophia - Lucioles", "15/12/22 18:00-00:00"),
				new Event("Hackathon", "C'est le Hakcathon", "Sophia - Templiers", "10/11/22 16:00-20:00")});
	}
}
