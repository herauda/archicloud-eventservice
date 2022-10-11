package archicloud.equipeh.eventservice.model;

public class Event {
	private String name;
	private String description;
	private String place;
	private String date;
	
	public Event(String name, String description, String place, String date) {
		this.name = name;
		this.description = description;
		this.place = place;
		this.date = date;
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
}
