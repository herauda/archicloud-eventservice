package si5.cloud.h.eventservice.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import si5.cloud.h.eventservice.controller.model.Event;

@Service
public class EventPersistenceService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Event> getEventsInDb() {
		List<Event> dbEvents = new ArrayList<>();
		
		jdbcTemplate.query("select * from EVENT", new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Event event = new Event(
						rs.getString("Event_Name"), 
						rs.getString("Event_Desc"),
						rs.getString("Event_Place"),
						rs.getString("Event_Date"), 
						rs.getInt("Event_Capacity"));
				dbEvents.add(event);
			}
		});
		
		return dbEvents;
	}
}
