package com.app.eventapp.Model;

public class EventModel {

    String eventName, eventImage;

    public EventModel(){

    }

    public EventModel(String eventName, String eventImage) {
        this.eventName = eventName;
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }
}
