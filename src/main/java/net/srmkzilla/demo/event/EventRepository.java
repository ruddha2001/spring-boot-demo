package net.srmkzilla.demo.event;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EventRepository extends MongoRepository<Event, String> {

    @Query(value = "{eventName:'?0'}", delete = true)
    public void deleteEventByEventName(String eventName);

    @Query(value = "{eventName:'?0'}")
    public List<Event> findEventsByEventName(String eventName);
}
