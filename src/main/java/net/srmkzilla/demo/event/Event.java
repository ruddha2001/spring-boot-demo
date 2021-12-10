package net.srmkzilla.demo.event;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {
    @Id
    private String _id;

    @NotNull(message = "The 'eventName' property cannot be null.")
    private String eventName;

    @NotNull(message = "The 'eventDate' property cannot be null.")
    private String eventDate;

    @NotNull(message = "The 'isActive' property cannot be null.")
    private boolean isActive;

    public Event(String _id, String eventName, String eventDate, boolean isActive) {
        this._id = _id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.isActive = isActive;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{" +
                " _id='" + get_id() + "'" +
                ", eventName='" + getEventName() + "'" +
                ", eventDate='" + getEventDate() + "'" +
                ", isActive='" + isIsActive() + "'" +
                "}";
    }

}
