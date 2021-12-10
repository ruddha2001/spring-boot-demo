package net.srmkzilla.demo.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// The @RequestMapping on the main class adds a prefix to all the handler methods
@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/")
    public List<Event> handleGetAllEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> handleAddNewEvent(@Valid @RequestBody Event eventData) {
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            eventService.addNewEvent(eventData);
            response.put("status", true);
            response.put("message", "The new event was added successfully.");
        } catch (Exception e) {
            response.put("status", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, Object> handleUpdateExisitingEvent(@RequestParam String eventName,
            @RequestParam String eventDate) {
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            eventService.updateExisitngEvent(eventName, eventDate);
            response.put("status", true);
            response.put("message", "The exisitng event was updated successfully.");
        } catch (Exception e) {
            response.put("status", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Map<String, Object> handleDeleteEventByEventName(@RequestParam String eventName) {
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            eventService.deleteEventByEventName(eventName);
            response.put("status", true);
            response.put("message", "The exisitng event was deleted successfully.");
        } catch (Exception e) {
            response.put("status", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
