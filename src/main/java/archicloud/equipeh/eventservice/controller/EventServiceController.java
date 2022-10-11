package archicloud.equipeh.eventservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventServiceController {
	@GetMapping(value = "/all")
	public ResponseEntity<String> getModulesAccess() {
		return ResponseEntity.ok("All Events");
	}
}