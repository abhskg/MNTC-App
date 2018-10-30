package com.example.oem.mntc_app;

public class events {
    private String events_date="Default";
    private String events_time="Default";
    private String events_image="Default";
    private String events_description="Default";
    private String events_venue="Default";

    public String getEvents_date(){
        return events_date;
    }

    public void setEvents_date(String events_date) {
        this.events_date = events_date;
    }

    public String getEvents_time(){
        return events_time;
    }

    public void setEvents_time(String events_time) {
        this.events_time = events_time;
    }

    public String getEvents_image(){
        return events_image;
    }

    public void setEvents_image(String events_image) {
        this.events_image = events_image;
    }

    public String getEvents_description(){
        return events_description;
    }

    public void setEvents_description(String events_description) {
        this.events_description = events_description;
    }

    public String getEvents_venue(){
        return events_venue;
    }

    public void setEvents_venue(String events_venue) {
        this.events_venue = events_venue;
    }
}
