package com.app.eventapp.Model;

public class EventPlaceModel {

    String eventPlaceName, eventPlaceImage;

    public EventPlaceModel(){

    }

    public EventPlaceModel(String eventPlaceName, String eventPlaceImage) {
        this.eventPlaceName = eventPlaceName;
        this.eventPlaceImage = eventPlaceImage;
    }

    public String getEventPlaceName() {
        return eventPlaceName;
    }

    public void setEventPlaceName(String eventPlaceName) {
        this.eventPlaceName = eventPlaceName;
    }

    public String getEventPlaceImage() {
        return eventPlaceImage;
    }

    public void setEventPlaceImage(String eventPlaceImage) {
        this.eventPlaceImage = eventPlaceImage;
    }
}
