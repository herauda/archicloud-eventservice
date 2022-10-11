package si5.cloud.h.eventservice.controller.model.dto;

public class EventBookDTO {
	private String eventName;
	private String ticketHolder; 
	
	public EventBookDTO(String eventName, String ticketHolder) {
		this.eventName = eventName;
		this.ticketHolder = ticketHolder;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTicketHolder() {
		return ticketHolder;
	}

	public void setTicketHolder(String ticketHolder) {
		this.ticketHolder = ticketHolder;
	}
}
