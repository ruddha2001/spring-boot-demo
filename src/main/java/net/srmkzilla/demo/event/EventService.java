package net.srmkzilla.demo.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    void addNewEvent(Event newEvent) {
        eventRepository.save(newEvent);
    }

    void updateExisitngEvent(String eventName, String eventDate) throws Exception {
        List<Event> eventList = eventRepository.findEventsByEventName(eventName);
        if (eventList.size() == 0)
            throw new Exception("No such event with the name " + eventName + " was found");
        Event oldEvent = eventList.get(0);
        oldEvent.setEventDate(eventDate);
        eventRepository.save(oldEvent);
    }

    void deleteEventByEventName(String eventName) {
        eventRepository.deleteEventByEventName(eventName);
    }
}
