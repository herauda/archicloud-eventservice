package si5.cloud.h.eventservice.controller.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
	private String name;
	private String description;
	private String place;
	private String date;
	private int ticketCapacity;
	private int availableTickets;
	private List<Ticket> boughtTickets;
	
	public Event(String name, String description, String place, String date, int ticketCapacity) {
		this.name = name;
		this.description = description;
		this.place = place;
		this.date = date;
		this.ticketCapacity = ticketCapacity;
		this.availableTickets = ticketCapacity;
		this.boughtTickets = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTicketCapacity() {
		return ticketCapacity;
	}
	
	public void addTicketCapacity(int addedCapacity) {
		this.ticketCapacity += addedCapacity;
		this.availableTickets += addedCapacity;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public List<Ticket> getBoughtTickets() {
		return boughtTickets;
	}
	
	public void bookTicket(Ticket ticket) {
		if (availableTickets <= 0) {
			throw new IllegalArgumentException("Event capacity is full");
		}
		
		if (this.boughtTickets.add(ticket)) {
			availableTickets--;
		}
	}
}
